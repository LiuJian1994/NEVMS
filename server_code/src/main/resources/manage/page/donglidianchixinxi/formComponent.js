Vue.component('donglidianchixinxi-form', {
template:`
<template>
    <div>
        <el-dialog
                :visible.sync="formVisible"
                :title="formTitle"
                v-if="formVisible"
                custom-class="formModel"
                width="60%" >
            <el-form class="formModel_form" ref="formRef" :model="form" :rules="rules" >
                <el-form-item prop="cheliangtupian"
                              label="车辆图片"
                              v-if="formVisible" class="imgUpload-item">
                    <file-upload
                            :disabled="!isAdd||disabledForm.cheliangtupian?true:false"
                            tip="点击上传车辆图片"
                            :limit="3"
                            action="file/upload"
                            :multiple="true"
                            :file-urls="form.cheliangtupian?form.cheliangtupian:''"
                            @change="cheliangtupianUploadSuccess"
                    ></file-upload>
                </el-form-item>
                <el-form-item  label="车牌号" prop="chepaihao" class="input-item">
                    <el-input v-model="form.chepaihao"
                       placeholder="车牌号"
                       type="text"
                       :readonly="!isAdd||disabledForm.chepaihao?true:false" ></el-input>
                </el-form-item>
                <el-form-item  label="电池电量" prop="dianchidianliang" class="input-item">
                    <el-input v-model="form.dianchidianliang"
                       placeholder="电池电量"
                       type="text"
                       :readonly="!isAdd||disabledForm.dianchidianliang?true:false" ></el-input>
                </el-form-item>
                <el-form-item  label="剩余容量" prop="shengyurongliang" class="input-item">
                    <el-input v-model="form.shengyurongliang"
                       placeholder="剩余容量"
                       type="text"
                       :readonly="!isAdd||disabledForm.shengyurongliang?true:false" ></el-input>
                </el-form-item>
                <el-form-item  label="电压" prop="dianya" class="input-item">
                    <el-input v-model="form.dianya"
                       placeholder="电压"
                       type="text"
                       :readonly="!isAdd||disabledForm.dianya?true:false" ></el-input>
                </el-form-item>
                <el-form-item  label="循环次数" prop="xunhuancishu" class="input-item">
                    <el-input v-model="form.xunhuancishu"
                       placeholder="循环次数"
                       type="text"
                       :readonly="!isAdd||disabledForm.xunhuancishu?true:false" ></el-input>
                </el-form-item>
                <el-form-item  label="电池温度" prop="dianchiwendu" class="input-item">
                    <el-input v-model="form.dianchiwendu"
                       placeholder="电池温度"
                       type="text"
                       :readonly="!isAdd||disabledForm.dianchiwendu?true:false" ></el-input>
                </el-form-item>
                <el-form-item  label="充电电流" prop="chongdiandianliu" class="input-item">
                    <el-input v-model="form.chongdiandianliu"
                       placeholder="充电电流"
                       type="text"
                       :readonly="!isAdd||disabledForm.chongdiandianliu?true:false" ></el-input>
                </el-form-item>
                <el-form-item  label="最大充电电流" prop="zuidachongdiandianliu" class="input-item">
                    <el-input v-model="form.zuidachongdiandianliu"
                       placeholder="最大充电电流"
                       type="text"
                       :readonly="!isAdd||disabledForm.zuidachongdiandianliu?true:false" ></el-input>
                </el-form-item>
                <el-form-item  label="用户名" prop="yonghuming" class="input-item">
                    <el-input v-model="form.yonghuming"
                       placeholder="用户名"
                       type="text"
                       :readonly="!isAdd||disabledForm.yonghuming?true:false" ></el-input>
                </el-form-item>
            </el-form>
            <div class="formModel-btns" v-if="isAdd||type=='reply'">
                <el-button class="formModel_cancel" @click="closeClick">取消</el-button>
                <el-button class="formModel_confirm" type="primary" @click="save"
                    >
                    提交
                </el-button>
            </div>
        </el-dialog>
    </div>
</template>
`,
data() {
    return {
        formVisible:false,
        formTitle:'',
        id:0,
        form:{},
        type:'',
        formName:'动力电池信息',
        rules:{
            cheliangtupian: [
            ],
            chepaihao: [
            ],
            dianchidianliang: [
                {required: true,message: '请输入',trigger: 'blur'},

            ],
            shengyurongliang: [
                {required: true,message: '请输入',trigger: 'blur'},

            ],
            dianya: [
                {required: true,message: '请输入',trigger: 'blur'},

            ],
            xunhuancishu: [
                {required: true,message: '请输入',trigger: 'blur'},

            ],
            dianchiwendu: [
                {required: true,message: '请输入',trigger: 'blur'},

            ],
            chongdiandianliu: [
                {required: true,message: '请输入',trigger: 'blur'},

            ],
            zuidachongdiandianliu: [
                {required: true,message: '请输入',trigger: 'blur'},

            ],
            yonghuming: [
            ],
        },
        isAdd:false,
        disabledForm:{
            cheliangtupian : false,
            chepaihao : false,
            dianchidianliang : false,
            shengyurongliang : false,
            dianya : false,
            xunhuancishu : false,
            dianchiwendu : false,
            chongdiandianliu : false,
            zuidachongdiandianliu : false,
            yonghuming : false,
        },
        crossRow:'',
        crossTips:'',
        crossColumnName:'',
        crossColumnValue:'',
        userInfo:{},
        sessionTable:localStorage.getItem('admin_sessionTable'),
    }
},
watch:{
},
methods: {
    init(formId=null,formType='add',formNames='',row=null,table=null,statusColumnName=null,tips=null,statusColumnValue=null){
        this.resetForm()
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
                if(x=='dianchidianliang'){
                    this.form.dianchidianliang = row[x];
                    this.disabledForm.dianchidianliang = true;
                    continue;
                }
                if(x=='shengyurongliang'){
                    this.form.shengyurongliang = row[x];
                    this.disabledForm.shengyurongliang = true;
                    continue;
                }
                if(x=='dianya'){
                    this.form.dianya = row[x];
                    this.disabledForm.dianya = true;
                    continue;
                }
                if(x=='xunhuancishu'){
                    this.form.xunhuancishu = row[x];
                    this.disabledForm.xunhuancishu = true;
                    continue;
                }
                if(x=='dianchiwendu'){
                    this.form.dianchiwendu = row[x];
                    this.disabledForm.dianchiwendu = true;
                    continue;
                }
                if(x=='chongdiandianliu'){
                    this.form.chongdiandianliu = row[x];
                    this.disabledForm.chongdiandianliu = true;
                    continue;
                }
                if(x=='zuidachongdiandianliu'){
                    this.form.zuidachongdiandianliu = row[x];
                    this.disabledForm.zuidachongdiandianliu = true;
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
    },
    getInfo(){
        http.get(`donglidianchixinxi/info/${this.id}`).then(res=>{
            let reg=new RegExp('../../../upload','g')
            this.form = res.data.data
            this.formVisible = true
        })
    },
    //重置表单
    resetForm(){
        Object.assign(this.$data,this.$options.data())
        this.form = {
            cheliangtupian: '',
            chepaihao: '',
            dianchidianliang: '',
            shengyurongliang: '',
            dianya: '',
            xunhuancishu: '',
            dianchiwendu: '',
            chongdiandianliu: '',
            zuidachongdiandianliu: '',
            yonghuming: '',
        }
    },

        //车辆图片上传回调
    cheliangtupianUploadSuccess(e){
        this.form.cheliangtupian = e
        if(e){
            http.get(`donglidianchixinxi/baidu/ocr?fileName=`+e.substr(e.lastIndexOf("/")+1)).then(res=>{
                this.form.chepaihao = res.data.data
            })
        }
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
                http.get('donglidianchixinxi/page',{
                    params:params
                }).then(res=>{
                    if(res.data.data.total>=crossOptNum){
                        return this.$message.error(this.crossTips)
                    }else{
                        http.post(`donglidianchixinxi/${!this.form.id ? "save" : "update"}`,this.form).then(res=>{
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
                http.post(`donglidianchixinxi/${!this.form.id ? "save" : "update"}`,this.form).then(res=>{
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
},
})
document.write(`<script src="../../components/FileUpload.js"></script>`)
