
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
 * 赛程安排
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/siachenganpai")
public class SiachenganpaiController {
    private static final Logger logger = LoggerFactory.getLogger(SiachenganpaiController.class);

    private static final String TABLE_NAME = "siachenganpai";

    @Autowired
    private SiachenganpaiService siachenganpaiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BisaixiangmuService bisaixiangmuService;//项目信息
    @Autowired
    private BisaixiangmuYuyueService bisaixiangmuYuyueService;//项目报名
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private NewsService newsService;//公告资讯
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
        CommonUtil.checkMap(params);
        PageUtils page = siachenganpaiService.queryPage(params);

        //字典表数据转换
        List<SiachenganpaiView> list =(List<SiachenganpaiView>)page.getList();
        for(SiachenganpaiView c:list){
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
        SiachenganpaiEntity siachenganpai = siachenganpaiService.selectById(id);
        if(siachenganpai !=null){
            //entity转view
            SiachenganpaiView view = new SiachenganpaiView();
            BeanUtils.copyProperties( siachenganpai , view );//把实体数据重构到view中
            //级联表 项目信息
            //级联表
            BisaixiangmuEntity bisaixiangmu = bisaixiangmuService.selectById(siachenganpai.getBisaixiangmuId());
            if(bisaixiangmu != null){
            BeanUtils.copyProperties( bisaixiangmu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setBisaixiangmuId(bisaixiangmu.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(siachenganpai.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody SiachenganpaiEntity siachenganpai, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,siachenganpai:{}",this.getClass().getName(),siachenganpai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            siachenganpai.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<SiachenganpaiEntity> queryWrapper = new EntityWrapper<SiachenganpaiEntity>()
            .eq("bisaixiangmu_id", siachenganpai.getBisaixiangmuId())
            .eq("yonghu_id", siachenganpai.getYonghuId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SiachenganpaiEntity siachenganpaiEntity = siachenganpaiService.selectOne(queryWrapper);
        if(siachenganpaiEntity==null){
            siachenganpai.setInsertTime(new Date());
            siachenganpai.setCreateTime(new Date());
            siachenganpaiService.insert(siachenganpai);
            return R.ok();
        }else {
            return R.error(511,"请不要重复添加");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SiachenganpaiEntity siachenganpai, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,siachenganpai:{}",this.getClass().getName(),siachenganpai.toString());
        SiachenganpaiEntity oldSiachenganpaiEntity = siachenganpaiService.selectById(siachenganpai.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            siachenganpai.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            siachenganpaiService.updateById(siachenganpai);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<SiachenganpaiEntity> oldSiachenganpaiList =siachenganpaiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        siachenganpaiService.deleteBatchIds(Arrays.asList(ids));

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
            List<SiachenganpaiEntity> siachenganpaiList = new ArrayList<>();//上传的东西
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
                            SiachenganpaiEntity siachenganpaiEntity = new SiachenganpaiEntity();
//                            siachenganpaiEntity.setBisaixiangmuId(Integer.valueOf(data.get(0)));   //项目 要改的
//                            siachenganpaiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            siachenganpaiEntity.setSiachenganpaiFuzhenr(data.get(0));                    //比赛时间 要改的
//                            siachenganpaiEntity.setSiachenganpaiPhone(data.get(0));                    //比赛场地 要改的
//                            siachenganpaiEntity.setZhuangtaiTypes(Integer.valueOf(data.get(0)));   //比赛状态 要改的
//                            siachenganpaiEntity.setSiachenganpaiTypes(Integer.valueOf(data.get(0)));   //比赛结果 要改的
//                            siachenganpaiEntity.setSiachenganpaiContent("");//详情和图片
//                            siachenganpaiEntity.setInsertTime(date);//时间
//                            siachenganpaiEntity.setCreateTime(date);//时间
                            siachenganpaiList.add(siachenganpaiEntity);


                            //把要查询是否重复的字段放入map中
                                //比赛场地
                                if(seachFields.containsKey("siachenganpaiPhone")){
                                    List<String> siachenganpaiPhone = seachFields.get("siachenganpaiPhone");
                                    siachenganpaiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> siachenganpaiPhone = new ArrayList<>();
                                    siachenganpaiPhone.add(data.get(0));//要改的
                                    seachFields.put("siachenganpaiPhone",siachenganpaiPhone);
                                }
                        }

                        //查询是否重复
                         //比赛场地
                        List<SiachenganpaiEntity> siachenganpaiEntities_siachenganpaiPhone = siachenganpaiService.selectList(new EntityWrapper<SiachenganpaiEntity>().in("siachenganpai_phone", seachFields.get("siachenganpaiPhone")));
                        if(siachenganpaiEntities_siachenganpaiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SiachenganpaiEntity s:siachenganpaiEntities_siachenganpaiPhone){
                                repeatFields.add(s.getSiachenganpaiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [比赛场地] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        siachenganpaiService.insertBatch(siachenganpaiList);
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
        PageUtils page = siachenganpaiService.queryPage(params);

        //字典表数据转换
        List<SiachenganpaiView> list =(List<SiachenganpaiView>)page.getList();
        for(SiachenganpaiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SiachenganpaiEntity siachenganpai = siachenganpaiService.selectById(id);
            if(siachenganpai !=null){


                //entity转view
                SiachenganpaiView view = new SiachenganpaiView();
                BeanUtils.copyProperties( siachenganpai , view );//把实体数据重构到view中

                //级联表
                    BisaixiangmuEntity bisaixiangmu = bisaixiangmuService.selectById(siachenganpai.getBisaixiangmuId());
                if(bisaixiangmu != null){
                    BeanUtils.copyProperties( bisaixiangmu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setBisaixiangmuId(bisaixiangmu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(siachenganpai.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R add(@RequestBody SiachenganpaiEntity siachenganpai, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,siachenganpai:{}",this.getClass().getName(),siachenganpai.toString());
        Wrapper<SiachenganpaiEntity> queryWrapper = new EntityWrapper<SiachenganpaiEntity>()
            .eq("bisaixiangmu_id", siachenganpai.getBisaixiangmuId())
            .eq("yonghu_id", siachenganpai.getYonghuId())
            .eq("siachenganpai_fuzhenr", siachenganpai.getSiachenganpaiFuzhenr())
            .eq("siachenganpai_phone", siachenganpai.getSiachenganpaiPhone())
            .eq("zhuangtai_types", siachenganpai.getZhuangtaiTypes())
            .eq("siachenganpai_types", siachenganpai.getSiachenganpaiTypes())
//            .notIn("siachenganpai_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SiachenganpaiEntity siachenganpaiEntity = siachenganpaiService.selectOne(queryWrapper);
        if(siachenganpaiEntity==null){
            siachenganpai.setInsertTime(new Date());
            siachenganpai.setCreateTime(new Date());
        siachenganpaiService.insert(siachenganpai);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

