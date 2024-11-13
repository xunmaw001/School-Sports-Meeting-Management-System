const base = {
    get() {
        return {
            url : "http://localhost:8080/xiaoyunhuiguanli/",
            name: "xiaoyunhuiguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xiaoyunhuiguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校运会管理系统"
        } 
    }
}
export default base
