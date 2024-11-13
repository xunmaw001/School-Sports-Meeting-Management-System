
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
 * 运动会资讯
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zixun")
public class ZixunController {
    private static final Logger logger = LoggerFactory.getLogger(ZixunController.class);

    private static final String TABLE_NAME = "zixun";

    @Autowired
    private ZixunService zixunService;


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
    private SiachenganpaiService siachenganpaiService;//赛程安排
    @Autowired
    private YonghuService yonghuService;//用户
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
        params.put("zixunDeleteStart",1);params.put("zixunDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = zixunService.queryPage(params);

        //字典表数据转换
        List<ZixunView> list =(List<ZixunView>)page.getList();
        for(ZixunView c:list){
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
        ZixunEntity zixun = zixunService.selectById(id);
        if(zixun !=null){
            //entity转view
            ZixunView view = new ZixunView();
            BeanUtils.copyProperties( zixun , view );//把实体数据重构到view中
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
    public R save(@RequestBody ZixunEntity zixun, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zixun:{}",this.getClass().getName(),zixun.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZixunEntity> queryWrapper = new EntityWrapper<ZixunEntity>()
            .eq("zixun_name", zixun.getZixunName())
            .eq("zixun_video", zixun.getZixunVideo())
            .eq("zixun_types", zixun.getZixunTypes())
            .eq("zixun_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZixunEntity zixunEntity = zixunService.selectOne(queryWrapper);
        if(zixunEntity==null){
            zixun.setZixunClicknum(1);
            zixun.setZixunDelete(1);
            zixun.setInsertTime(new Date());
            zixun.setCreateTime(new Date());
            zixunService.insert(zixun);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZixunEntity zixun, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zixun:{}",this.getClass().getName(),zixun.toString());
        ZixunEntity oldZixunEntity = zixunService.selectById(zixun.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(zixun.getZixunPhoto()) || "null".equals(zixun.getZixunPhoto())){
                zixun.setZixunPhoto(null);
        }
        if("".equals(zixun.getZixunVideo()) || "null".equals(zixun.getZixunVideo())){
                zixun.setZixunVideo(null);
        }

            zixunService.updateById(zixun);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZixunEntity> oldZixunList =zixunService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ZixunEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ZixunEntity zixunEntity = new ZixunEntity();
            zixunEntity.setId(id);
            zixunEntity.setZixunDelete(2);
            list.add(zixunEntity);
        }
        if(list != null && list.size() >0){
            zixunService.updateBatchById(list);
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
            List<ZixunEntity> zixunList = new ArrayList<>();//上传的东西
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
                            ZixunEntity zixunEntity = new ZixunEntity();
//                            zixunEntity.setZixunName(data.get(0));                    //资讯标题 要改的
//                            zixunEntity.setZixunPhoto("");//详情和图片
//                            zixunEntity.setZixunVideo(data.get(0));                    //视频 要改的
//                            zixunEntity.setZixunTypes(Integer.valueOf(data.get(0)));   //资讯类型 要改的
//                            zixunEntity.setZixunClicknum(Integer.valueOf(data.get(0)));   //资讯热度 要改的
//                            zixunEntity.setZixunContent("");//详情和图片
//                            zixunEntity.setZixunDelete(1);//逻辑删除字段
//                            zixunEntity.setInsertTime(date);//时间
//                            zixunEntity.setCreateTime(date);//时间
                            zixunList.add(zixunEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        zixunService.insertBatch(zixunList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ZixunView> returnZixunViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("zixunYesnoTypes",2);
        PageUtils pageUtils = zixunCollectionService.queryPage(params1);
        List<ZixunCollectionView> collectionViewsList =(List<ZixunCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ZixunCollectionView collectionView:collectionViewsList){
            Integer zixunTypes = collectionView.getZixunTypes();
            if(typeMap.containsKey(zixunTypes)){
                typeMap.put(zixunTypes,typeMap.get(zixunTypes)+1);
            }else{
                typeMap.put(zixunTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("zixunTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("zixunYesnoTypes",2);
            PageUtils pageUtils1 = zixunService.queryPage(params2);
            List<ZixunView> zixunViewList =(List<ZixunView>)pageUtils1.getList();
            returnZixunViewList.addAll(zixunViewList);
            if(returnZixunViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("zixunYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = zixunService.queryPage(params);
        if(returnZixunViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnZixunViewList.size();//要添加的数量
            List<ZixunView> zixunViewList =(List<ZixunView>)page.getList();
            for(ZixunView zixunView:zixunViewList){
                Boolean addFlag = true;
                for(ZixunView returnZixunView:returnZixunViewList){
                    if(returnZixunView.getId().intValue() ==zixunView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnZixunViewList.add(zixunView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnZixunViewList = returnZixunViewList.subList(0, limit);
        }

        for(ZixunView c:returnZixunViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnZixunViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = zixunService.queryPage(params);

        //字典表数据转换
        List<ZixunView> list =(List<ZixunView>)page.getList();
        for(ZixunView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZixunEntity zixun = zixunService.selectById(id);
            if(zixun !=null){

                //点击数量加1
                zixun.setZixunClicknum(zixun.getZixunClicknum()+1);
                zixunService.updateById(zixun);

                //entity转view
                ZixunView view = new ZixunView();
                BeanUtils.copyProperties( zixun , view );//把实体数据重构到view中

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
    public R add(@RequestBody ZixunEntity zixun, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zixun:{}",this.getClass().getName(),zixun.toString());
        Wrapper<ZixunEntity> queryWrapper = new EntityWrapper<ZixunEntity>()
            .eq("zixun_name", zixun.getZixunName())
            .eq("zixun_video", zixun.getZixunVideo())
            .eq("zixun_types", zixun.getZixunTypes())
            .eq("zixun_clicknum", zixun.getZixunClicknum())
            .eq("zixun_delete", zixun.getZixunDelete())
//            .notIn("zixun_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZixunEntity zixunEntity = zixunService.selectOne(queryWrapper);
        if(zixunEntity==null){
            zixun.setZixunClicknum(1);
            zixun.setZixunDelete(1);
            zixun.setInsertTime(new Date());
            zixun.setCreateTime(new Date());
        zixunService.insert(zixun);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

