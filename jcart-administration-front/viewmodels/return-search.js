var app = new Vue({
    el: '#app',
    data: {
        pageInfo: '',
        pageNum: 1,
        returnId: '',
        orderId: '',
        customerName: '',
        productCode: '',
        productName: '',
        startTime: '',
        endTime: '',
        selectedStatus: '',
        statuses: [
            { value: 0, label: '待处理' },
            { value: 1, label: '待取货' },
            { value: 2, label: '正在处理' },
            { value: 3, label: '完成' },
            { value: 4, label: '拒绝' }
        ]
    },
    mounted() {
        console.log('view mounted');
        this.searchReturn();
    },
    methods: {
        handleSearchClick(){
            console.log('search click');
            this.searchReturn();
        },
        handleClearClick(){
            console.log('clear search');
            this.returnId = '';
            this.orderId = '';
            this.customerName = '';
            this.productCode = '';
            this.productName = '';
            this.startTime = '';
            this.endTime = '';
            this.selectedStatus = '';
        },
        handlePageChange(val){
            console.log('page changed',val);
            this.pageNum = val;
            this.searchReturn();
        },
        searchReturn() {
            axios.get('/return/search',{
                params: {
                    returnId: this.returnId,
                    orderId: this.orderId,
                    customerName: this.customerName,
                    productCode: this.productCode,
                    productName: this.productName,
                    status: this.selectedStatus,
                    startTimestamp: this.startTime ? this.startTime.getTime() : '',
                    endTimestamp: this.endTime ? this.endTime.getTime() : '',
                    pageNum: this.pageNum
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.pageInfo = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})