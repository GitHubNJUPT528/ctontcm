<template>
	<view class="s-page-wrapper is-100vh">
		<view>
			<view class="logoimg">
				<image src="/static/imgs/time.png" mode="aspectFit"></image>
			</view>
		</view>
		<view class="content">
			<view>
				<view class="inputbox">
					<text>账户</text>
					<input type="number" maxlength="11" v-model="phone" placeholder="请输入用户名" class="input"  />
					<!-- <input type="number" maxlength="11" v-model="login.phone" placeholder="请输入手机号" class="is-input1 " @input="BindPhoneInput" data-val="phone" /> -->
				</view>
				<view class="inputbox">
					<text>密码</text>
					<!-- 不显示输入密码-->
					<input placeholder="请输入登录密码" v-model="password" :password="true" class="input" />
				</view>
				<view class="inputbox2">
					<view class="loginbtn">
						<button value="登录" @click="logBtoClick()">登录</button>
					</view>
				</view>
				<view class="inputbox2">
					<navigator url="../registered/registered" open-type="navigate">
					    <view class="registerbtn">
					    	<button>注 册</button>
					    </view>
					</navigator>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	// import {
	//     mapMutations
	// } from 'vuex';
	  
	export default {
		data() {
			return {
					loading: false,
					phone:"",
					password:""
				
			};
		},
		// onLoad : function() {
		// 		var _self = this;
		// 		// uni.setStorage({
		// 		// 	key:'phone',
		// 		// 	data:'password',
		// 		// 	success() {
		// 		// 		console.log('缓存成功了')
		// 		// 	},
		// 		// 	fail() {
		// 		// 		console.log('缓存失败了')
		// 		// 	}
		// 		// });
		//     }
			// ,
		methods:{
			// BindPhoneInput:function(e){
			// 	//var dataval = e.currentTarget.dataset.val;
			// 	this.login.phone = e.detail.value; 
			// },
			// BindPasswordInput:function(e){
			// 	//var dataval = e.currentTarget.dataset.val;
			// 	this.login.password= e.detail.value; 
			// },
			logBtoClick:function(e){
				var phone = this.phone
				var password = this.password
				if(!(phone && password))
				{
					uni.showModal({
					    content: "请输入用户名和密码！！！",
					    showCancel: false,
					});
					return;
				}
				else {
					console.log('账号'+phone+'密码'+password)
					uni.switchTab({
					    url: '/pages/mine/mine'
					});
				}
				// uni.request({
				//             url: '/yto/consignor/login',
				//             method:"POST",
				//             // header : {'content-type':'application/x-www-form-urlencoded'},
				// 			header : {'content-type':'application/json'},
				//             data: {
				//                 phone: phone,
				//                 password: password
				//             },
				            
				//             success: (res) => {
				// 				console.log(res.data);
				//                  if (e.statusCode !== 200) {
				//                     uni.showModal({
				//                         content: "请求失败，请重试!!!",
				//                         showCancel: false,
				//                     });
				//                     // return;
				//                 }
				// 				if(res.data.code == 200)
				// 				{
				// 					uni.setStorage({
				// 						key: 'phone',
				// 						data: phone,
				// 						success() {
				// 							console.log('缓存成功了')
				// 						},
				// 						fail() {
				// 							console.log('缓存失败了')
				// 						}
				// 					});
				// 					console.log(res.data.data);
				// 					uni.setStorage({
				// 						key: 'username',
				// 						data: res.data.data.username,
				// 						success() {
				// 							console.log('username缓存成功了')
				// 						},
				// 						fail() {
				// 							console.log('username缓存失败了')
				// 						}
				// 					});
				// 					uni.setStorage({
				// 						key: 'id',
				// 						data: res.data.data.id,
				// 						success() {
				// 							console.log('id缓存成功了')
				// 						},
				// 						fail() {
				// 							console.log('id缓存失败了')
				// 						}
				// 					});
				// 					uni.setStorage({
				// 						key: 'realName',
				// 						data: res.data.data.realName,
				// 						success() {
				// 							console.log('id缓存成功了')
				// 						},
				// 						fail() {
				// 							console.log('id缓存失败了')
				// 						}
				// 					});
				// 					wx.switchTab({
				// 						url:'../index/index'
				// 					})
				// 				}
				// 				else{
				// 					console.log(res.data);
				// 					uni.showModal({
				// 					    content: "用户名或密码错误",
				// 					    showCancel: false,								
				// 					});
				// 				}
				//             },
				//             fail: (e) => {
				//                 uni.showModal({
				//                     content: "请求失败，请重试！",
				//                     showCancel: false
				//                 })
				//             },
				//             complete: () => {
				//                 this.loading = false;
				//             }
				//         })
				    },
				     // ...mapMutations(['login'])
		
	}
}
</script>

<style>
	page {
		min-height: 100%;
		background-color: #FFFFFF;
	}

	.content {
		width: 75%;
		margin: 0 auto;
	}
	
	.inputbox {
		display: flex;
		flex-direction: row;
		margin-top: 10rpx;
	}
	
	.inputbox2 {
		/* display: flex;
		flex-direction: row; */
		margin-top: 10rpx;
	}
	
	.inputbox text {
		width: 20%;
		display: flex;
		justify-content: center;
		align-items: center;
		
	}

	.loginbtn button {
		margin-top: 20rpx;
		height: 88rpx;
		width: 100%;
		line-height: 88rpx;
		color: #ffffff;
		font-size: 32rpx;
		border-radius: 44rpx;
		outline: 0;
		display: block;
		margin: 0;
		font-family: inherit;
		background: #FA8623;
		opacity: 0.8;
	}
	.registerbtn button {
		margin-top: 20rpx;
		height: 88rpx;
		width: 100%;
		line-height: 88rpx;
		color: #ffffff;
		font-size: 32rpx;
		border-radius: 44rpx;
		outline: 0;
		display: block;
		margin: 0;
		font-family: inherit;
		background: #FA8623;
		opacity: 0.8;
	}

/* 	button:after {
		border: 2rpx solid #f2f2f2;
	} */

	.logoimg {
		margin-top: 10rpx;
		margin-bottom: 50rpx;
		width: 100%;
		height: 500rpx;
	}

	.input {
		height: 88rpx;
		width: 100%;
		line-height: 88rpx;
		padding: 12rpx;
		color: #353535;
		font-size: 32rpx;
		box-sizing: border-box;
		appearance: none;
		border: 2rpx solid #e5e5e5;
		box-shadow: none;
		border-radius: 44rpx;
		outline: 0;
		display: block;
		padding-left: 30rpx;
		margin: 0;
		font-family: inherit;
		background: #fff;
		resize: none;
	}
</style>
