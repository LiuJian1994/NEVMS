Vue.component('cheliangxinxi-form',{
    template: `
    <div>
        <el-dialog :fullscreen="false" width="80%" 
                   :visible.sync="formVisible"
                   :title="formTitle"
                   v-if="formVisible"
                   custom-class="formModel">
            <el-form ref="formRef" :model="form" class="formModel_form" :rules="rules" label-width="120px" >
                <el-form-item label="车辆图片" prop="cheliangtupian" class="upload-item img-upload-item">
                    <file-upload
                            :disabled="!isAdd||disabledForm.cheliangtupian?true:false"
                            action="file/upload"
                            tip="请上传车辆图片"
                            :limit="3"
                            :fileUrls="form.cheliangtupian?form.cheliangtupian:''"
                            @change="cheliangtupianUploadSuccess">
                    </file-upload>
                </el-form-item>
                <el-form-item label="车牌号" prop="chepaihao" class="input-item">
                    <el-input v-model="form.chepaihao" placeholder="车牌号"
                              type="text"
                        :readonly="!isAdd||disabledForm.chepaihao?true:false" ></el-input>
                </el-form-item>
                <el-form-item label="汽车类型" prop="qicheleixing" class="select-item">
                    <el-select
                            :disabled="!isAdd||disabledForm.qicheleixing?true:false"
                            v-model="form.qicheleixing"
                            placeholder="请选择汽车类型"
                    >
                    <el-option v-for="(item,index) in qicheleixingLists" :label="item"
                               :value="item"
                        >
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="汽车品牌" prop="qichepinpai" class="input-item">
                    <el-input v-model="form.qichepinpai" placeholder="汽车品牌"
                              type="text"
                        :readonly="!isAdd||disabledForm.qichepinpai?true:false" ></el-input>
                </el-form-item>
                <el-form-item label="车辆颜色" prop="cheliangyanse" class="input-item">
                    <el-input v-model="form.cheliangyanse" placeholder="车辆颜色"
                              type="text"
                        :readonly="!isAdd||disabledForm.cheliangyanse?true:false" ></el-input>
                </el-form-item>
                <el-form-item label="动力电池品牌" prop="donglidianchipinpai" class="input-item">
                    <el-input v-model="form.donglidianchipinpai" placeholder="动力电池品牌"
                              type="text"
                        :readonly="!isAdd||disabledForm.donglidianchipinpai?true:false" ></el-input>
                </el-form-item>
                <el-form-item label="制造日期" prop="zhizaoriqi" class="date-item">
                    <el-date-picker
                            v-model="form.zhizaoriqi"
                            format="yyyy 年 MM 月 dd 日"
                            value-format="yyyy-MM-dd"
                            type="datetime"
                            :readonly="!isAdd||disabledForm.zhizaoriqi?true:false"
                            placeholder="请选择制造日期"
                            ></el-date-picker>
                </el-form-item>
                <el-form-item label="所有人" prop="suoyouren" class="input-item">
                    <el-input v-model="form.suoyouren" placeholder="所有人"
                              type="text"
                        :readonly="!isAdd||disabledForm.suoyouren?true:false" ></el-input>
                </el-form-item>
                <el-form-item label="用户名" prop="yonghuming" class="input-item">
                    <el-input v-model="form.yonghuming" placeholder="用户名"
                              type="text"
                        :readonly="!isAdd||disabledForm.yonghuming?true:false" ></el-input>
                </el-form-item>
            </el-form>
            <div v-if="isAdd||type=='reply'" class="formModel-btns">
                <el-button class="formModel_cancel" @click="closeClick">取消</el-button>
                <el-button class="formModel_confirm" type="primary" @click="save">
                    提交
                </el-button>
            </div>
        </el-dialog>
    </div>
`,
    data(){
        return{
            sessionTable:localStorage.getItem('sessionTable'),
            tableName:'cheliangxinxi',
            formName:'车辆信息',
            formVisible:false,
            formTitle:'',
            form:{
                cheliangtupian: '',
                chepaihao: '',
                qicheleixing: '',
                qichepinpai: '',
                cheliangyanse: '',
                donglidianchipinpai: '',
                zhizaoriqi: '',
                suoyouren: '',
                yonghuming: '',
            },
            id:0,
            type:'',
            disabledForm:{
                cheliangtupian : false,
                chepaihao : false,
                qicheleixing : false,
                qichepinpai : false,
                cheliangyanse : false,
                donglidianchipinpai : false,
                zhizaoriqi : false,
                suoyouren : false,
                yonghuming : false,
            },
            isAdd:false,
            rules:{
                cheliangtupian: [
                    {required: true,message: '请输入',trigger: 'blur'},
                ],
                chepaihao: [
                    {required: true,message: '请输入',trigger: 'blur'},
                ],
                qicheleixing: [
                ],
                qichepinpai: [
                    {required: true,message: '请输入',trigger: 'blur'},
                ],
                cheliangyanse: [
                    {required: true,message: '请输入',trigger: 'blur'},
                ],
                donglidianchipinpai: [
                    {required: true,message: '请输入',trigger: 'blur'},
                ],
                zhizaoriqi: [
                    {required: true,message: '请输入',trigger: 'blur'},
                ],
                suoyouren: [
                    {required: true,message: '请输入',trigger: 'blur'},
                ],
                yonghuming: [
                ],
            },
            //汽车类型列表
                qicheleixingLists:[],
            crossRow:'',
            crossTable:'',
            crossTips:'',
            crossColumnName:'',
            crossColumnValue:'',
        }
    },
    watch:{
    },
    methods:{
        //获取唯一标识
        getUUID(){
            return new Date().getTime();
        },
        //车辆图片上传回调
        cheliangtupianUploadSuccess(e){
        this.form.cheliangtupian = e
            //文字识别
            if(e){
                http.get(`cheliangxinxi/baidu/ocr?fileName=`+e.substr(e.lastIndexOf("/")+1)).then(res=>{
                    this.form.chepaihao = res.data.data
                })
            }
        },
        getInfo(){
            http.get(`${this.tableName}/info/${this.id}`).then(res=>{
                this.form = res.data.data
                this.formVisible = true
            })
        },
        init(formId=null,formType='add',formNames='',row=null,table=null,statusColumnName=null,tips=null,statusColumnValue=null){
            if(formId){
                this.id = formId
                this.type = formType
            }
            if(formType == 'add'){
                this.isAdd = true
                this.formTitle = '新增' + this.formName
                this.formVisible = true
            } else if(formType == 'info'){
                this.isAdd = false
                this.formTitle = '查看' + this.formName
                this.getInfo()
            } else if(formType == 'edit'){
                this.isAdd = true
                this.formTitle = '修改' + this.formName
                this.getInfo()
            } else if(formType == 'reply'){
                this.type = formType
                this.isAdd = true
                this.disabledForm.cpicture = true
                this.disabledForm.content = true
                this.formTitle = '回复'
                this.getInfo()
            } else if(formType == 'cross'){
                this.isAdd = true
                this.formTitle = formNames
                for(let x in row){
                    if(x=='cheliangtupian'){
                        this.form.cheliangtupian = row[x];
                        this.disabledForm.cheliangtupian = true;
                        continue;
                    }
                    if(x=='chepaihao'){
                        this.form.chepaihao = row[x];
                        this.disabledForm.chepaihao = true;
                        continue;
                    }
                    if(x=='qicheleixing'){
                        this.form.qicheleixing = row[x];
                        this.disabledForm.qicheleixing = true;
                        continue;
                    }
                    if(x=='qichepinpai'){
                        this.form.qichepinpai = row[x];
                        this.disabledForm.qichepinpai = true;
                        continue;
                    }
                    if(x=='cheliangyanse'){
                        this.form.cheliangyanse = row[x];
                        this.disabledForm.cheliangyanse = true;
                        continue;
                    }
                    if(x=='donglidianchipinpai'){
                        this.form.donglidianchipinpai = row[x];
                        this.disabledForm.donglidianchipinpai = true;
                        continue;
                    }
                    if(x=='zhizaoriqi'){
                        this.form.zhizaoriqi = row[x];
                        this.disabledForm.zhizaoriqi = true;
                        continue;
                    }
                    if(x=='suoyouren'){
                        this.form.suoyouren = row[x];
                        this.disabledForm.suoyouren = true;
                        continue;
                    }
                    if(x=='yonghuming'){
                        this.form.yonghuming = row[x];
                        this.disabledForm.yonghuming = true;
                        continue;
                    }
                }
                if(row){
                    this.crossRow = row
                }
                if(table){
                    this.crossTable = table
                }
                if(tips){
                    this.crossTips = tips
                }
                if(statusColumnName){
                    this.crossColumnName = statusColumnName
                }
                if(statusColumnValue){
                    this.crossColumnValue = statusColumnValue
                }
                this.formVisible = true
            }
            http.get(this.sessionTable+'/session').then(res=>{
                var json = res.data.data
                if((json.yonghuming || json.yonghuming==0) && toolUtil.storageGet("role")!="管理员"){
                    this.form.yonghuming = json.yonghuming
                    this.disabledForm.yonghuming = true;
                }
            })
            this.qicheleixingLists = "混动汽车(HEV),纯电动汽车(EV)".split(',')
        },
        //关闭
        closeClick(){
            this.formVisible = false
        },
        //提交
        save(){
            if(this.form.cheliangtupian!=null) {
                this.form.cheliangtupian = this.form.cheliangtupian.replace(new RegExp(baseUrl,"g"),"");
            }
            let objcross;
            let crossUserId = ''
            let crossRefId = ''
            let crossOptNum = ''
            if(this.type == 'cross'){
                objcross = JSON.parse(JSON.stringify(this.crossRow))
                if(this.crossColumnName!=''){
                    if(!this.crossColumnName.startsWith('[')){
                        for(let o in objcross){
                            if(o == this.crossColumnName){
                                objcross[o] = this.crossColumnValue
                            }
                        }
                    }else{
                        crossUserId = toolUtil.storageGet('userid')
                        crossRefId = objcross['id']
                        crossOptNum = this.crossColumnName.replace(/\[|\]/g,"")
                    }
                }
            }
            this.$refs.formRef.validate((valid)=>{
                if(!valid)return
                if(crossUserId&&crossRefId){
                    this.form.crossuserid = crossUserId
                    this.form.crossrefid = crossRefId
                    let params = {
                        page: 1,
                        limit: 1000,
                        crossuserid:this.form.crossuserid,
                        crossrefid:this.form.crossrefid,
                    }
                    http.get('cheliangxinxi/page',{
                        params:params
                    }).then(res=>{
                        if(res.data.data.total>=crossOptNum){
                            return this.$message.error(this.crossTips)
                        }else{
                            http.post(`cheliangxinxi/${!this.form.id ? "save" : "update"}`,this.form).then(res=>{
                                if(this.type == 'cross'){
                                    //修改跨表数据
                                    this.changeCrossData(objcross)
                                }
                                this.$message.success('操作成功')
                                this.formVisible = false
                                this.$emit('change')
                            })
                        }
                    })
                }else{
                    http.post(`cheliangxinxi/${!this.form.id ? "save" : "update"}`,this.form).then(res=>{
                        if(this.type == 'cross'){
                            //修改跨表数据
                            this.changeCrossData(objcross)
                        }
                        this.$message.success('操作成功')
                        this.formVisible = false
                        this.$emit('change')
                    })
                }
            })
        },
        changeCrossData(data){
            http.post(`${this.crossTable}/update`,data)
        },
    }
})
document.write(`<script src="../../components/FileUpload.js"></script>`)
document.write(`<script src="${baseUrl}client/static/modules/wangeditor/index.min.js"></script>`)
document.write(`<script src="../../components/myEditor.js"></script>`)
document.write(`<link rel="stylesheet" href="${baseUrl}client/static/modules/wangeditor/style.css"></link>`)
