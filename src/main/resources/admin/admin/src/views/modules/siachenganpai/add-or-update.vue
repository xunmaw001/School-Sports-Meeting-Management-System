<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                >
            <el-row>
               <!-- <el-col :span="12"  v-if="sessionTable !='bisaixiangmu'">
                    <el-form-item class="select" v-if="type!='info'"  label="项目信息" prop="bisaixiangmuId">
                        <el-select v-model="ruleForm.bisaixiangmuId" :disabled="ro.bisaixiangmuId" filterable placeholder="请选择项目信息" @change="bisaixiangmuChange">
                            <el-option
                                    v-for="(item,index) in bisaixiangmuOptions"
                                    v-bind:key="item.id"
                                    :label="item.bisaixiangmuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col> -->

                <el-col :span="12"  v-if="sessionTable !='bisaixiangmu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="项目标题" prop="bisaixiangmuName">
                        <el-input v-model="bisaixiangmuForm.bisaixiangmuName"
                                  placeholder="项目标题" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="项目标题" prop="bisaixiangmuName">
                            <el-input v-model="ruleForm.bisaixiangmuName"
                                      placeholder="项目标题" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='bisaixiangmu' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.bisaixiangmuPhoto" label="项目封面" prop="bisaixiangmuPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (bisaixiangmuForm.bisaixiangmuPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.bisaixiangmuPhoto" label="项目封面" prop="bisaixiangmuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.bisaixiangmuPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='bisaixiangmu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="工作时间" prop="bisaixiangmuShijian">
                        <el-input v-model="bisaixiangmuForm.bisaixiangmuShijian"
                                  placeholder="工作时间" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="工作时间" prop="bisaixiangmuShijian">
                            <el-input v-model="ruleForm.bisaixiangmuShijian"
                                      placeholder="工作时间" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='bisaixiangmu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="负责人" prop="bisaixiangmuFuzhenr">
                        <el-input v-model="bisaixiangmuForm.bisaixiangmuFuzhenr"
                                  placeholder="负责人" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="负责人" prop="bisaixiangmuFuzhenr">
                            <el-input v-model="ruleForm.bisaixiangmuFuzhenr"
                                      placeholder="负责人" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='bisaixiangmu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="联系方式" prop="bisaixiangmuPhone">
                        <el-input v-model="bisaixiangmuForm.bisaixiangmuPhone"
                                  placeholder="联系方式" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="联系方式" prop="bisaixiangmuPhone">
                            <el-input v-model="ruleForm.bisaixiangmuPhone"
                                      placeholder="联系方式" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='bisaixiangmu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="项目类型" prop="bisaixiangmuValue">
                        <el-input v-model="bisaixiangmuForm.bisaixiangmuValue"
                                  placeholder="项目类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="项目类型" prop="bisaixiangmuValue">
                            <el-input v-model="ruleForm.bisaixiangmuValue"
                                      placeholder="项目类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='bisaixiangmu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="结束时间" prop="jieshuTime">
                        <el-input v-model="bisaixiangmuForm.jieshuTime"
                                  placeholder="结束时间" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="结束时间" prop="jieshuTime">
                            <el-input v-model="ruleForm.jieshuTime"
                                      placeholder="结束时间" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <!-- <el-col :span="12"  v-if="sessionTable !='yonghu'">
                    <el-form-item class="select" v-if="type!='info'"  label="用户" prop="yonghuId">
                        <el-select v-model="ruleForm.yonghuId" :disabled="ro.yonghuId" filterable placeholder="请选择用户" @change="yonghuChange">
                            <el-option
                                    v-for="(item,index) in yonghuOptions"
                                    v-bind:key="item.id"
                                    :label="item.yonghuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col> -->

                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户名称" prop="yonghuName">
                        <el-input v-model="yonghuForm.yonghuName"
                                  placeholder="用户名称" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户名称" prop="yonghuName">
                            <el-input v-model="ruleForm.yonghuName"
                                      placeholder="用户名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户手机号" prop="yonghuPhone">
                        <el-input v-model="yonghuForm.yonghuPhone"
                                  placeholder="用户手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户手机号" prop="yonghuPhone">
                            <el-input v-model="ruleForm.yonghuPhone"
                                      placeholder="用户手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户身份证号" prop="yonghuIdNumber">
                        <el-input v-model="yonghuForm.yonghuIdNumber"
                                  placeholder="用户身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户身份证号" prop="yonghuIdNumber">
                            <el-input v-model="ruleForm.yonghuIdNumber"
                                      placeholder="用户身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='yonghu' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (yonghuForm.yonghuPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.yonghuPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户邮箱" prop="yonghuEmail">
                        <el-input v-model="yonghuForm.yonghuEmail"
                                  placeholder="用户邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户邮箱" prop="yonghuEmail">
                            <el-input v-model="ruleForm.yonghuEmail"
                                      placeholder="用户邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="bisaixiangmuId" name="bisaixiangmuId" type="hidden">
            <input id="yonghuId" name="yonghuId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="比赛时间" prop="siachenganpaiFuzhenr">
                       <el-input v-model="ruleForm.siachenganpaiFuzhenr"
                                 placeholder="比赛时间" clearable  :readonly="ro.siachenganpaiFuzhenr"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="比赛时间" prop="siachenganpaiFuzhenr">
                           <el-input v-model="ruleForm.siachenganpaiFuzhenr"
                                     placeholder="比赛时间" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="比赛场地" prop="siachenganpaiPhone">
                       <el-input v-model="ruleForm.siachenganpaiPhone"
                                 placeholder="比赛场地" clearable  :readonly="ro.siachenganpaiPhone"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="比赛场地" prop="siachenganpaiPhone">
                           <el-input v-model="ruleForm.siachenganpaiPhone"
                                     placeholder="比赛场地" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <div v-if="type=='info'">
                        <el-form-item class="input" label="比赛状态" prop="zhuangtaiValue">
                        <el-input v-model="ruleForm.zhuangtaiValue"
                            placeholder="比赛状态" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="ruleForm.zhuangtaiTypes == 2">
                    <el-form-item class="select" v-if="type!='info'"  label="比赛结果" prop="siachenganpaiTypes">
                        <el-select v-model="ruleForm.siachenganpaiTypes" :disabled="ro.siachenganpaiTypes" placeholder="请选择比赛结果">
                            <el-option
                                v-for="(item,index) in siachenganpaiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="比赛结果" prop="siachenganpaiValue">
                        <el-input v-model="ruleForm.siachenganpaiValue"
                            placeholder="比赛结果" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col v-if="ruleForm.zhuangtaiTypes == 2" :span="24">
                    <el-form-item v-if="type!='info' && !ro.siachenganpaiContent"  label="比赛详情" prop="siachenganpaiContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.siachenganpaiContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.siachenganpaiContent" label="比赛详情" prop="siachenganpaiContent">
                            <span v-html="ruleForm.siachenganpaiContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back(2)">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back(1)">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                bisaixiangmuForm: {},
                yonghuForm: {},
                ro:{
                    bisaixiangmuId: false,
                    yonghuId: false,
                    siachenganpaiFuzhenr: false,
                    siachenganpaiPhone: false,
                    zhuangtaiTypes: false,
                    siachenganpaiTypes: false,
                    siachenganpaiContent: false,
                    insertTime: false,
                },
                ruleForm: {
                    bisaixiangmuId: '',
                    yonghuId: '',
                    siachenganpaiFuzhenr: '',
                    siachenganpaiPhone: '',
                    zhuangtaiTypes: 1,
                    siachenganpaiTypes: '',
                    siachenganpaiContent: '',
                    insertTime: '',
                },
                zhuangtaiTypesOptions : [],
                siachenganpaiTypesOptions : [],
                bisaixiangmuOptions : [],
                yonghuOptions : [],
                rules: {
                   bisaixiangmuId: [
                              { required: true, message: '项目不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   yonghuId: [
                              { required: true, message: '用户不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   siachenganpaiFuzhenr: [
                              { required: true, message: '比赛时间不能为空', trigger: 'blur' },
                          ],
                   siachenganpaiPhone: [
                              {  required: true, message: '比赛场地不能为空', trigger: 'blur' },
                          ],
                   zhuangtaiTypes: [
                              { required: true, message: '比赛状态不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   siachenganpaiTypes: [
                              { required: true, message: '比赛结果不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   siachenganpaiContent: [
                              { required: true, message: '比赛详情不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '发布日期不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.$route.query.bisaixiangmuId !=null && this.$route.query.yonghuId != null){
				this.ruleForm.bisaixiangmuId = this.$route.query.bisaixiangmuId
				this.ruleForm.yonghuId = this.$route.query.yonghuId
				this.yonghuChange(this.ruleForm.yonghuId )
				this.bisaixiangmuChange(this.ruleForm.bisaixiangmuId)
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=zhuangtai_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zhuangtaiTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=siachenganpai_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.siachenganpaiTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `bisaixiangmu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.bisaixiangmuOptions = data.data.list;
            }
         });
         this.$http({
             url: `yonghu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yonghuOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            bisaixiangmuChange(id){
                this.$http({
                    url: `bisaixiangmu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.bisaixiangmuForm = data.data;
                    }
                });
            },
            yonghuChange(id){
                this.$http({
                    url: `yonghu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yonghuForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `siachenganpai/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.bisaixiangmuChange(data.data.bisaixiangmuId)
                        _this.yonghuChange(data.data.yonghuId)
                        _this.ruleForm.siachenganpaiContent = _this.ruleForm.siachenganpaiContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
				let _this = this
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.ruleForm.siachenganpaiContent = this.ruleForm.siachenganpaiContent.replaceAll(this.$base.url,"");
                        this.$http({
                            url:`siachenganpai/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
									
										if(_this.ruleForm.zhuangtaiTypes == 1){
											this.$router.push({path: '/siachenganpai'})
										} else {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.siachenganpaiCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange(); 
										}
									}	
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back(types) {
				if(types == 1){
					this.parent.showFlag = true;
					this.parent.addOrUpdateFlag = false;
					this.parent.siachenganpaiCrossAddOrUpdateFlag = false;
					this.parent.contentStyleChange();
				}else{
					this.$router.push(
						{
							path: '/bisaixiangmuYuyue',
						}
					)
				}
               
            },
            //图片

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}</style>

