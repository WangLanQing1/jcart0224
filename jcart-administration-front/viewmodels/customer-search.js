var app = new Vue({
    el: '#app',
    data: {
        pageInfo: '',
        pageNum: 1,
        username: '',
        realName: '',
        mobile: '',
        email: '',
        selectedStatus: '',
        statuses: [
            { value: 0, label:'禁用' },
            { value: 1, label:'启用' },
            { value: 2, label:'不安全' }
        ]
    },
    mounted(){
        console.log('view mounted');
        this.searchCustomer();
    },
    methods: {
        handleSearchClick() {
            console.log('search click');
            this.pageNum = 1;
            this.searchCustomer();
        },
        handleClearClick() {
            console.log('clear click');
            this.username = '';
            this.realName = '';
            this.mobile = '';
            this.email = '';
            this.selectedStatus = '';
        },
        handlePageChange(val){
            console.log('page changed');
            this.pageNum = val;
            this.searchCustomer();
        },
        handleUpdateStatus(index,row){
            console.log('update status click');
            this.updateCustomerStatus(row.customerId,row.status);
        },
        searchCustomer(){
            axios.get('/customer/search',{
                param: {
                    username: this.username,
                    realName: this.realName,
                    mobile: this.mobile,
                    email: this.email,
                    status: this.selectedStatus,
                    pageNum: this.pageNum
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.pageInfo = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        updateCustomerStatus(customerId,status){
            axios.post('/customer/setStatus',{
                customerId: customerId,
                status: status
            })
                .then(function (response) {
                    console.log(response);
                    alert('状态更新成功');
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})