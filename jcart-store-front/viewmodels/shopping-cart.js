var app = new Vue({
    el:'#app',
    data: {
        myShoppingCart: []
    },
    computed: {
        totalPrice() {
            var subTotalPrices = this.myShoppingCart.map(p =>{
                return p.unitPrice * p.quantity;
            });
            var totalPrice = subTotalPrices.reduce((a,b) => a+b,0);
            var totalPriceStr = totalPrice.toFixed(2);
            totalPrice = parseFloat(totalPriceStr);
            return totalPrice;
        }
    },
    mounted() {
        console.log('view mounted');
        var myShoppingCartJson = localStorage['myShoppingCartJson'];
        this.myShoppingCart = myShoppingCartJson ? JSON.parse(myShoppingCartJson) : [];
    },
    methods: {
        handleDelete(index,row){
            console.log('delete click');
            if (confirm('确认删除吗?')){
                this.myShoppingCart.splice(index,1);
                localStorage['myShoppingCartJson'] = JSON.stringify(this.myShoppingCart);
                this.$message.success('删除购物车成功');
            }
        },
        handleUpdate(index,row){
            console.log('update click');
            localStorage['myShoppingCartJson'] = JSON.stringify(this.myShoppingCart);
            this.$message.success('修改购物车成功');
        }

    }
})