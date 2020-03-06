var app = Vue({
    el: '#app',
    data: {
        address: []
    },
    mounted(){
        console.log('view mounted');
        this.getMyAddresses();
    },
    methods: {
        getMyAddresses() {
            axios.get('/address/getCustomerAddress')
                .then(function (response) {
                    console.log(response);
                    app.address = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})