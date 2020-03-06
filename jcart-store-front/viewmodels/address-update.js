var app = new Vue({
    el: '#app',
    data: {
        addressId: '',
        tag: '',
        receiverName: '',
        receiverMobile: '',
        content: ''
    },
    mounted() {
        console.log('view mounted');

        var url = new URL(location.href);
        this.addressId = url.searchParams.get("addressId");
        if (!this.addressId){
            alert('addressId is null');
            return;
        }

        this.getAddressById();
    },
    methods: {
        handleUpdateClick(){
            console.log('update click');
            this.updateAddress();
        },
        getAddressById(){
            axios.get("/address/getById",{
                params: {
                    addressId: this.addressId
                }
            })
                .then(function (response) {
                    console.log(response);
                    var address = response.data;
                    app.tag = address.tag;
                    app.receiverMobile = address.receiverMobile;
                    app.receiverName = address.receiverName;
                    app.content = address.content;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})