Vue.component('cheliangweixiu-form', {
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
                <el-form-item  label="车辆颜色" prop="cheliangyanse" class="input-item">
                    <el-input v-model="form.cheliangyanse"
                       placeholder="车辆颜色"
                       type="text"
                       :readonly="!isAdd||disabledForm.cheliangyanse?true:false" ></el-input>
                </el-form-item>
                <el-form-item  label="维修部位" prop="weixiubuwei" class="input-item">
                    <el-input v-model="form.weixiubuwei"
                       placeholder="维修部位"
                       type="text"
                       :readonly="!isAdd||disabledForm.weixiubuwei?true:false" ></el-input>
                </el-form-item>
                <el-form-item label="维修时间" prop="weixiushijian" class="date-item">
                    <el-date-picker
                            v-model="form.weixiushijian"
                            format="yyyy 年 MM 月 dd 日"
                            value-format="yyyy-MM-dd"
                            type="date"
                            :readonly="!isAdd||disabledForm.weixiushijian?true:false"
                            placeholder="请选择维修时间"/>
                </el-form-item>
                <el-form-item label="制造日期" prop="zhizaoriqi" class="date-item">
                    <el-date-picker
                            v-model="form.zhizaoriqi"
                            format="yyyy 年 MM 月 dd 日"
                            value-format="yyyy-MM-dd"
                            type="date"
                            :readonly="!isAdd||disabledForm.zhizaoriqi?true:false"
                            placeholder="请选择制造日期"/>
                </el-form-item>
                <el-form-item  label="保养人员" prop="baoyangrenyuan" class="input-item">
                    <el-input v-model="form.baoyangrenyuan"
                       placeholder="保养人员"
                       type="text"
                       :readonly="!isAdd||disabledForm.baoyangrenyuan?true:false" ></el-input>
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
        formName:'车辆维修',
        rules:{
            cheliangtupian: [
            ],
            chepaihao: [
            ],
            cheliangyanse: [
            ],
            weixiubuwei: [
                {required: true,message: '请输入',trigger: 'blur'},

            ],
            weixiushijian: [
                {required: true,message: '请输入',trigger: 'blur'},

            ],
            zhizaoriqi: [
            ],
            baoyangrenyuan: [
                {required: true,message: '请输入',trigger: 'blur'},

            ],
            yonghuming: [
            ],
        },
        isAdd:false,
        disabledForm:{
            cheliangtupian : false,
            chepaihao : false,
            cheliangyanse : false,
            weixiubuwei : false,
            weixiushijian : false,
            zhizaoriqi : false,
            baoyangrenyuan : false,
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
                if(x=='cheliangyanse'){
                    this.form.cheliangyanse = row[x];
                    this.disabledForm.cheliangyanse = true;
                    continue;
                }
                if(x=='weixiubuwei'){
                    this.form.weixiubuwei = row[x];
                    this.disabledForm.weixiubuwei = true;
                    continue;
                }
                if(x=='weixiushijian'){
                    this.form.weixiushijian = row[x];
                    this.disabledForm.weixiushijian = true;
                    continue;
                }
                if(x=='zhizaoriqi'){
                    this.form.zhizaoriqi = row[x];
                    this.disabledForm.zhizaoriqi = true;
                    continue;
                }
                if(x=='baoyangrenyuan'){
                    this.form.baoyangrenyuan = row[x];
                    this.disabledForm.baoyangrenyuan = true;
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
        http.get(`cheliangweixiu/info/${this.id}`).then(res=>{
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
            cheliangyanse: '',
            weixiubuwei: '',
            weixiushijian: '',
            zhizaoriqi: '',
            baoyangrenyuan: '',
            yonghuming: '',
        }
    },

        //车辆图片上传回调
    cheliangtupianUploadSuccess(e){
        this.form.cheliangtupian = e
        if(e){
            http.get(`cheliangweixiu/baidu/ocr?fileName=`+e.substr(e.lastIndexOf("/")+1)).then(res=>{
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
                http.get('cheliangweixiu/page',{
                    params:params
                }).then(res=>{
                    if(res.data.data.total>=crossOptNum){
                        return this.$message.error(this.crossTips)
                    }else{
                        http.post(`cheliangweixiu/${!this.form.id ? "save" : "update"}`,this.form).then(res=>{
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
                http.post(`cheliangweixiu/${!this.form.id ? "save" : "update"}`,this.form).then(res=>{
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
