Vue.component('yonghu-form', {
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
                <el-form-item label="用户名" prop="yonghuming" class="input-item">
                    <el-input v-model="form.yonghuming"
                           placeholder="用户名"
                           type="text"
                           :readonly="!isAdd||disabledForm.yonghuming?true:false"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="mima" class="input-item">
                    <el-input v-model="form.mima"
                           placeholder="密码"
                           type="password"
                           :readonly="!isAdd||disabledForm.mima?true:false"></el-input>
                </el-form-item>
                <el-form-item  label="姓名" prop="xingming" class="input-item">
                    <el-input v-model="form.xingming"
                       placeholder="姓名"
                       type="text"
                       :readonly="!isAdd||disabledForm.xingming?true:false" ></el-input>
                </el-form-item>
                <el-form-item label="性别" prop="xingbie" class="select-item">
                    <el-select
                        :disabled="!isAdd||disabledForm.xingbie?true:false"
                        v-model="form.xingbie"
                        placeholder="请选择性别"
                    >
                        <el-option v-for="(item,index) in xingbieLists" :label="item"
                               :value="item"
                        >
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="生日" prop="shengri" class="date-item">
                    <el-date-picker
                            v-model="form.shengri"
                            format="yyyy 年 MM 月 dd 日"
                            value-format="yyyy-MM-dd"
                            type="date"
                            :readonly="!isAdd||disabledForm.shengri?true:false"
                            placeholder="请选择生日"/>
                </el-form-item>
                <el-form-item  label="身份证" prop="shenfenzheng" class="input-item">
                    <el-input v-model="form.shenfenzheng"
                       placeholder="身份证"
                       type="text"
                       :readonly="!isAdd||disabledForm.shenfenzheng?true:false" ></el-input>
                </el-form-item>
                <el-form-item  label="手机" prop="shouji" class="input-item">
                    <el-input v-model="form.shouji"
                       placeholder="手机"
                       type="text"
                       :readonly="!isAdd||disabledForm.shouji?true:false" ></el-input>
                </el-form-item>
                <el-form-item prop="touxiang"
                              label="头像"
                              v-if="formVisible" class="imgUpload-item">
                    <file-upload
                            :disabled="!isAdd||disabledForm.touxiang?true:false"
                            tip="点击上传头像"
                            :limit="3"
                            action="file/upload"
                            :multiple="true"
                            :file-urls="form.touxiang?form.touxiang:''"
                            @change="touxiangUploadSuccess"
                    ></file-upload>
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
        formName:'用户',
        rules:{
            yonghuming: [
                {required: true,message: '请输入',trigger: 'blur'},

            ],
            mima: [
                {required: true,message: '请输入',trigger: 'blur'},

            ],
            xingming: [
                {required: true,message: '请输入',trigger: 'blur'},

            ],
            xingbie: [
            ],
            shengri: [
                {required: true,message: '请输入',trigger: 'blur'},

            ],
            shenfenzheng: [
                {required: true,message: '请输入',trigger: 'blur'},

                { validator: toolUtil.fromValidate.idCard, trigger: 'blur' },
            ],
            shouji: [
                {required: true,message: '请输入',trigger: 'blur'},

                { validator: toolUtil.fromValidate.mobile, trigger: 'blur' },
            ],
            touxiang: [
            ],
        },
        isAdd:false,
        disabledForm:{
            yonghuming : false,
            mima : false,
            xingming : false,
            xingbie : false,
            shengri : false,
            shenfenzheng : false,
            shouji : false,
            touxiang : false,
        },
        //性别列表
        xingbieLists:[],
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
                if(x=='yonghuming'){
                    this.form.yonghuming = row[x];
                    this.disabledForm.yonghuming = true;
                    continue;
                }
                if(x=='mima'){
                    this.form.mima = row[x];
                    this.disabledForm.mima = true;
                    continue;
                }
                if(x=='xingming'){
                    this.form.xingming = row[x];
                    this.disabledForm.xingming = true;
                    continue;
                }
                if(x=='xingbie'){
                    this.form.xingbie = row[x];
                    this.disabledForm.xingbie = true;
                    continue;
                }
                if(x=='shengri'){
                    this.form.shengri = row[x];
                    this.disabledForm.shengri = true;
                    continue;
                }
                if(x=='shenfenzheng'){
                    this.form.shenfenzheng = row[x];
                    this.disabledForm.shenfenzheng = true;
                    continue;
                }
                if(x=='shouji'){
                    this.form.shouji = row[x];
                    this.disabledForm.shouji = true;
                    continue;
                }
                if(x=='touxiang'){
                    this.form.touxiang = row[x];
                    this.disabledForm.touxiang = true;
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
        })
        this.xingbieLists = "男,女".split(',')
    },
    getInfo(){
        http.get(`yonghu/info/${this.id}`).then(res=>{
            let reg=new RegExp('../../../upload','g')
            this.form = res.data.data
            this.formVisible = true
        })
    },
    //重置表单
    resetForm(){
        Object.assign(this.$data,this.$options.data())
        this.form = {
            yonghuming: '',
            mima: '',
            xingming: '',
            xingbie: '',
            shengri: '',
            shenfenzheng: '',
            shouji: '',
            touxiang: '',
        }
    },








        //头像上传回调
    touxiangUploadSuccess(e){
        this.form.touxiang = e
    },
    //关闭
    closeClick(){
        this.formVisible = false
    },
    //提交
    save(){
        if(this.form.touxiang!=null) {
            this.form.touxiang = this.form.touxiang.replace(new RegExp(baseUrl,"g"),"");
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
                http.get('yonghu/page',{
                    params:params
                }).then(res=>{
                    if(res.data.data.total>=crossOptNum){
                        return this.$message.error(this.crossTips)
                    }else{
                        http.post(`yonghu/${!this.form.id ? "save" : "update"}`,this.form).then(res=>{
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
                http.post(`yonghu/${!this.form.id ? "save" : "update"}`,this.form).then(res=>{
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
