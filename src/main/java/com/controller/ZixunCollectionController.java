
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
 * 资讯收藏
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zixunCollection")
public class ZixunCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(ZixunCollectionController.class);

    private static final String TABLE_NAME = "zixunCollection";

    @Autowired
    private ZixunCollectionService zixunCollectionService;


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
    private ZixunService zixunService;//运动会资讯
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
        PageUtils page = zixunCollectionService.queryPage(params);

        //字典表数据转换
        List<ZixunCollectionView> list =(List<ZixunCollectionView>)page.getList();
        for(ZixunCollectionView c:list){
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
        ZixunCollectionEntity zixunCollection = zixunCollectionService.selectById(id);
        if(zixunCollection !=null){
            //entity转view
            ZixunCollectionView view = new ZixunCollectionView();
            BeanUtils.copyProperties( zixunCollection , view );//把实体数据重构到view中
            //级联表 运动会资讯
            //级联表
            ZixunEntity zixun = zixunService.selectById(zixunCollection.getZixunId());
            if(zixun != null){
            BeanUtils.copyProperties( zixun , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setZixunId(zixun.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(zixunCollection.getYonghuId());
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
    public R save(@RequestBody ZixunCollectionEntity zixunCollection, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zixunCollection:{}",this.getClass().getName(),zixunCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            zixunCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ZixunCollectionEntity> queryWrapper = new EntityWrapper<ZixunCollectionEntity>()
            .eq("zixun_id", zixunCollection.getZixunId())
            .eq("yonghu_id", zixunCollection.getYonghuId())
            .eq("zixun_collection_types", zixunCollection.getZixunCollectionTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZixunCollectionEntity zixunCollectionEntity = zixunCollectionService.selectOne(queryWrapper);
        if(zixunCollectionEntity==null){
            zixunCollection.setInsertTime(new Date());
            zixunCollection.setCreateTime(new Date());
            zixunCollectionService.insert(zixunCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZixunCollectionEntity zixunCollection, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zixunCollection:{}",this.getClass().getName(),zixunCollection.toString());
        ZixunCollectionEntity oldZixunCollectionEntity = zixunCollectionService.selectById(zixunCollection.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            zixunCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            zixunCollectionService.updateById(zixunCollection);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZixunCollectionEntity> oldZixunCollectionList =zixunCollectionService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        zixunCollectionService.deleteBatchIds(Arrays.asList(ids));

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
            List<ZixunCollectionEntity> zixunCollectionList = new ArrayList<>();//上传的东西
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
                            ZixunCollectionEntity zixunCollectionEntity = new ZixunCollectionEntity();
//                            zixunCollectionEntity.setZixunId(Integer.valueOf(data.get(0)));   //资讯 要改的
//                            zixunCollectionEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            zixunCollectionEntity.setZixunCollectionTypes(Integer.valueOf(data.get(0)));   //类型 要改的
//                            zixunCollectionEntity.setInsertTime(date);//时间
//                            zixunCollectionEntity.setCreateTime(date);//时间
                            zixunCollectionList.add(zixunCollectionEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        zixunCollectionService.insertBatch(zixunCollectionList);
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
        PageUtils page = zixunCollectionService.queryPage(params);

        //字典表数据转换
        List<ZixunCollectionView> list =(List<ZixunCollectionView>)page.getList();
        for(ZixunCollectionView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZixunCollectionEntity zixunCollection = zixunCollectionService.selectById(id);
            if(zixunCollection !=null){


                //entity转view
                ZixunCollectionView view = new ZixunCollectionView();
                BeanUtils.copyProperties( zixunCollection , view );//把实体数据重构到view中

                //级联表
                    ZixunEntity zixun = zixunService.selectById(zixunCollection.getZixunId());
                if(zixun != null){
                    BeanUtils.copyProperties( zixun , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZixunId(zixun.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(zixunCollection.getYonghuId());
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
    public R add(@RequestBody ZixunCollectionEntity zixunCollection, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zixunCollection:{}",this.getClass().getName(),zixunCollection.toString());
        Wrapper<ZixunCollectionEntity> queryWrapper = new EntityWrapper<ZixunCollectionEntity>()
            .eq("zixun_id", zixunCollection.getZixunId())
            .eq("yonghu_id", zixunCollection.getYonghuId())
            .eq("zixun_collection_types", zixunCollection.getZixunCollectionTypes())
//            .notIn("zixun_collection_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZixunCollectionEntity zixunCollectionEntity = zixunCollectionService.selectOne(queryWrapper);
        if(zixunCollectionEntity==null){
            zixunCollection.setInsertTime(new Date());
            zixunCollection.setCreateTime(new Date());
        zixunCollectionService.insert(zixunCollection);

            return R.ok();
        }else {
            return R.error(511,"您已经收藏过了");
        }
    }

}

