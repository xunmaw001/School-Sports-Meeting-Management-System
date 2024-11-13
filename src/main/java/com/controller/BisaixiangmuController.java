
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 项目信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/bisaixiangmu")
public class BisaixiangmuController {
    private static final Logger logger = LoggerFactory.getLogger(BisaixiangmuController.class);

    private static final String TABLE_NAME = "bisaixiangmu";

    @Autowired
    private BisaixiangmuService bisaixiangmuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BisaixiangmuYuyueService bisaixiangmuYuyueService;//项目报名
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private NewsService newsService;//公告资讯
    @Autowired
    private SiachenganpaiService siachenganpaiService;//赛程安排
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZixunService zixunService;//运动会资讯
    @Autowired
    private ZixunCollectionService zixunCollectionService;//资讯收藏
    @Autowired
    private ZixunLiuyanService zixunLiuyanService;//资讯留言
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("bisaixiangmuDeleteStart",1);params.put("bisaixiangmuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = bisaixiangmuService.queryPage(params);

        //字典表数据转换
        List<BisaixiangmuView> list =(List<BisaixiangmuView>)page.getList();
        for(BisaixiangmuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BisaixiangmuEntity bisaixiangmu = bisaixiangmuService.selectById(id);
        if(bisaixiangmu !=null){
            //entity转view
            BisaixiangmuView view = new BisaixiangmuView();
            BeanUtils.copyProperties( bisaixiangmu , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody BisaixiangmuEntity bisaixiangmu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,bisaixiangmu:{}",this.getClass().getName(),bisaixiangmu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<BisaixiangmuEntity> queryWrapper = new EntityWrapper<BisaixiangmuEntity>()
            .eq("bisaixiangmu_name", bisaixiangmu.getBisaixiangmuName())
            .eq("bisaixiangmu_shijian", bisaixiangmu.getBisaixiangmuShijian())
            .eq("bisaixiangmu_fuzhenr", bisaixiangmu.getBisaixiangmuFuzhenr())
            .eq("bisaixiangmu_phone", bisaixiangmu.getBisaixiangmuPhone())
            .eq("bisaixiangmu_types", bisaixiangmu.getBisaixiangmuTypes())
            .eq("bisaixiangmu_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BisaixiangmuEntity bisaixiangmuEntity = bisaixiangmuService.selectOne(queryWrapper);
        if(bisaixiangmuEntity==null){
            bisaixiangmu.setBisaixiangmuDelete(1);
            bisaixiangmu.setInsertTime(new Date());
            bisaixiangmu.setCreateTime(new Date());
            bisaixiangmuService.insert(bisaixiangmu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BisaixiangmuEntity bisaixiangmu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,bisaixiangmu:{}",this.getClass().getName(),bisaixiangmu.toString());
        BisaixiangmuEntity oldBisaixiangmuEntity = bisaixiangmuService.selectById(bisaixiangmu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(bisaixiangmu.getBisaixiangmuPhoto()) || "null".equals(bisaixiangmu.getBisaixiangmuPhoto())){
                bisaixiangmu.setBisaixiangmuPhoto(null);
        }

            bisaixiangmuService.updateById(bisaixiangmu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<BisaixiangmuEntity> oldBisaixiangmuList =bisaixiangmuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<BisaixiangmuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            BisaixiangmuEntity bisaixiangmuEntity = new BisaixiangmuEntity();
            bisaixiangmuEntity.setId(id);
            bisaixiangmuEntity.setBisaixiangmuDelete(2);
            list.add(bisaixiangmuEntity);
        }
        if(list != null && list.size() >0){
            bisaixiangmuService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<BisaixiangmuEntity> bisaixiangmuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            BisaixiangmuEntity bisaixiangmuEntity = new BisaixiangmuEntity();
//                            bisaixiangmuEntity.setBisaixiangmuName(data.get(0));                    //项目标题 要改的
//                            bisaixiangmuEntity.setBisaixiangmuPhoto("");//详情和图片
//                            bisaixiangmuEntity.setBisaixiangmuShijian(data.get(0));                    //工作时间 要改的
//                            bisaixiangmuEntity.setBisaixiangmuFuzhenr(data.get(0));                    //负责人 要改的
//                            bisaixiangmuEntity.setBisaixiangmuPhone(data.get(0));                    //联系方式 要改的
//                            bisaixiangmuEntity.setBisaixiangmuTypes(Integer.valueOf(data.get(0)));   //项目类型 要改的
//                            bisaixiangmuEntity.setJieshuTime(sdf.parse(data.get(0)));          //结束时间 要改的
//                            bisaixiangmuEntity.setBisaixiangmuContent("");//详情和图片
//                            bisaixiangmuEntity.setBisaixiangmuDelete(1);//逻辑删除字段
//                            bisaixiangmuEntity.setInsertTime(date);//时间
//                            bisaixiangmuEntity.setCreateTime(date);//时间
                            bisaixiangmuList.add(bisaixiangmuEntity);


                            //把要查询是否重复的字段放入map中
                                //联系方式
                                if(seachFields.containsKey("bisaixiangmuPhone")){
                                    List<String> bisaixiangmuPhone = seachFields.get("bisaixiangmuPhone");
                                    bisaixiangmuPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> bisaixiangmuPhone = new ArrayList<>();
                                    bisaixiangmuPhone.add(data.get(0));//要改的
                                    seachFields.put("bisaixiangmuPhone",bisaixiangmuPhone);
                                }
                        }

                        //查询是否重复
                         //联系方式
                        List<BisaixiangmuEntity> bisaixiangmuEntities_bisaixiangmuPhone = bisaixiangmuService.selectList(new EntityWrapper<BisaixiangmuEntity>().in("bisaixiangmu_phone", seachFields.get("bisaixiangmuPhone")).eq("bisaixiangmu_delete", 1));
                        if(bisaixiangmuEntities_bisaixiangmuPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BisaixiangmuEntity s:bisaixiangmuEntities_bisaixiangmuPhone){
                                repeatFields.add(s.getBisaixiangmuPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        bisaixiangmuService.insertBatch(bisaixiangmuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = bisaixiangmuService.queryPage(params);

        //字典表数据转换
        List<BisaixiangmuView> list =(List<BisaixiangmuView>)page.getList();
        for(BisaixiangmuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BisaixiangmuEntity bisaixiangmu = bisaixiangmuService.selectById(id);
            if(bisaixiangmu !=null){


                //entity转view
                BisaixiangmuView view = new BisaixiangmuView();
                BeanUtils.copyProperties( bisaixiangmu , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody BisaixiangmuEntity bisaixiangmu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,bisaixiangmu:{}",this.getClass().getName(),bisaixiangmu.toString());
        Wrapper<BisaixiangmuEntity> queryWrapper = new EntityWrapper<BisaixiangmuEntity>()
            .eq("bisaixiangmu_name", bisaixiangmu.getBisaixiangmuName())
            .eq("bisaixiangmu_shijian", bisaixiangmu.getBisaixiangmuShijian())
            .eq("bisaixiangmu_fuzhenr", bisaixiangmu.getBisaixiangmuFuzhenr())
            .eq("bisaixiangmu_phone", bisaixiangmu.getBisaixiangmuPhone())
            .eq("bisaixiangmu_types", bisaixiangmu.getBisaixiangmuTypes())
            .eq("bisaixiangmu_delete", bisaixiangmu.getBisaixiangmuDelete())
//            .notIn("bisaixiangmu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BisaixiangmuEntity bisaixiangmuEntity = bisaixiangmuService.selectOne(queryWrapper);
        if(bisaixiangmuEntity==null){
            bisaixiangmu.setBisaixiangmuDelete(1);
            bisaixiangmu.setInsertTime(new Date());
            bisaixiangmu.setCreateTime(new Date());
        bisaixiangmuService.insert(bisaixiangmu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

