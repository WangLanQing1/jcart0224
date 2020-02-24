# Administrator 管理员

|字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
|administrator_id | int | 主键 自增 | Id  |
|username | varchar(20) | 非空，唯一索引| 用户名 |
|status | tinyint | 非空，默认启用 |状态(0:禁用,1:启用) |
|create_time | datetime | 非空 | 创建时间|
|real_name | varchar(20) | 索引 | 姓名|
|email | varchar(20) | 非空 | 邮箱 |
|encrypted_password | varchar(100) | 非空 | 加密密码 |
|avatar_url | varchar(200) | | 头像地址 |

# product 商品
|字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
|product_id | int | 主键，自增 | Id |
|product_abstract | varchar(30) | | 摘要 |
|product_code | int | 非空 | 商品代号 |
|product_name | varchar(30) | 非空 | 商品名称 |
|price |double |非空 |价格 |
|discount |double | |打折 |
|stock_quantity |int |非空 |库存量|
|status |tinyint |非空 |状态(0:有货,1:无库存)|
|reword_points |int | |积分|
|main_pic_url |varchar(100) | |主图|

# productDetail 商品详情副表
|字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
|product_id |int |非空 |商品id|
|description |varchar(255) |非空 |商品简介|
|other_pic_url |varchar(255) | |其他图片 |

# order 订单
|字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
|order_id |int |主键，自增 |Id|
|customer_id |int |非空 |客户id|
|status |tinyint |非空，默认启用|状态(0待处理,1处理中,2待发货,3已发货,4待签收,5已签收,6待支付,7已支付,8取消,9拒绝,10完成)|
|total_price |double |非空 |总金额|
|create_time |datetime |非空 |创建时间|
|update_time |datetime |非空 |修改时间|
|reword_points |int| |积分|
|ship_method |tinyint |非空 |寄送方式(0默认,1快件,2慢件)|
|pay_method |tinyint |非空 |支付方式(0支付宝,1微信,2银行,3其他,4到付)|

# orderDetail订单详细副表
|字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
|order_id |int |非空 |订单id|
|ship_address |varchar(100) |非空 |寄送地址|
|invoice_address |varchar(100) | |发票地址|
|ship_price |double | |邮费|
|product_id |int |非空 |商品id|
|product_code |int |非空 |商品编号|
|product_name |varchar(30) |非空 |商品名称|
|unit_price |double |非空 |单价|
|quantity |int |非空 |数量|

# orderHistory订单历史
|字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
|order_id |int |非空 |订单id|
|order_history_id |int |非空 |订单历史id|
|time |datetime |非空 |历史时间|
|comment |varchar(30) | |备注|
|order_status |tinyint |非空 |订单状态(0已完成,1未完成,2取消)|
|customer_notified |tinyint |非空 |通知用户(0通知,1未通知)|

# return 退货
|字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
|return_id |int |主键,自增 |Id|
|order_id |int |非空 |订单id|
|order_time |datetime |非空 |订单时间|
|customer_name |datetime |非空 |客户退货时间|
|email |varchar(50) | |邮箱|
|mobile |varcher(13) | |手机|
|product_code |int |非空 |商品编号|
|product_name |varchar(30) |非空 |商品名称|
|quantity |int |非空 |数量|
|reason |tinyint |非空 |理由(0不需要了,1发货慢,2货不对款,3其他)|
|opened |tinyint |非空 |开封(0开封,1未开封)|
|comment |varchar(100) | |备注|
|action |tinyint |非空 |处理方式(0退货,1补发,其他)|

# ReturnHistory 退货历史
|字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
|return_id |int |非空 |退货id|
|return_history_id |int |主键,自增|退货历史id|
|time |datetime |非空 |退货时间|
|return_status |tinyint |非空 |退货状态(0补发,1返钱,2未处理)|
|comment |varchar(100) | |备注|
|customer_notified |tinyint |非空 |通知用户(0通知,1未通知)|

# customer客户
|字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
|customer_id |int |主键,自增 |Id|
|username |varchar(20) |非空 |用户名|
|mobile |varchar(13) |非空 |手机|
|mobile_venified |tinyint |非空 |手机验证(0通过,1未通过)|
|email |varchar(30) |非空 |邮箱|
|email_venified |tinyint |非空 |邮箱验证(0通过,1未通过)|
|real_name |varchar(30) |非空 |姓名|
|default_address_id |int |非空 |默认地址id|
|encrypted_password |varchar(100) |非空 |加密密码|
# Address 地址
|字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
|address_id |int |主键,自增 |Id|
|customer_id |int |非空 |客户id|
|receiver_names |varchar(30) |非空 |收货人姓名|
|receiver_mobile |varchar(13) |非空 |收货人手机|
|content |varchar(100) |非空 |地址内容|