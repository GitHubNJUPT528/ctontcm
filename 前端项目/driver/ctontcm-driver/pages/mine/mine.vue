<template>
	<view class="back">
		<view class="topbotton">
			<view class="littleThing">签到</view>
			<view class="littleThing">勋章</view>
		</view>
		<view class="userInfo">
			<image class="userimg" src="../../static/imgs/guodegang.png"></image>
			<view>
				<view class="userInformation">
					<text>187****6791</text>
					<view class="weirengzheng">未认证</view>
				</view>
				<text style="font-size: 30upx;padding-left: 20upx;color: #FA8623;">认证后享受更多服务</text>
			</view>
		</view>
		<view class="usuallymode">
			<view style="padding-top: 20upx;"></view>
			<text style="font-weight: 700; padding-left: 10upx;">常用工具</text>
			<view class="order_status">
				<view class="status" v-for="(item,index) in status" :key="index" @click="goToDetail(item.next)">
					<!-- <image class="icon" :src="item.url" mode="aspectFill"></image> -->
					<image class="icon" :src="item.imgurl" mode="aspectFill"></image>
					<text>{{item.name}}</text>
				</view>
			</view>
			<!-- <view class="ads">
				<view class="adss" v-for="(item,index) in status2" :key"index" @click="goToDetail(item.next)">
					<image class="icon" :src="item.imgurl"></image>
				</view>
			</view> -->
			<view class="adsssssss">
				<image class="adsImg" src="../../static/imgs/QQ20210123222444.png"></image>
				<image class="adsImg" src="../../static/imgs/QQ20210123222459.png"></image>
				<image class="adsImg" src="../../static/imgs/QQ20210123222507.png"></image>
			</view>
			<text style="font-weight: 700; padding-left: 10upx;" class="two">我的服务</text>
			<view class="order_status">
				<view class="status" v-for="(item,index) in status3" :key="index" @click="goToDetail(item.next)">
					<!-- <image class="icon" :src="item.url" mode="aspectFill"></image> -->
					<image class="icon" :src="item.imgurl" mode="aspectFill"></image>
					<text>{{item.name}}</text>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		userImgSrc:'/static/imgs/guodegang.png',
		data() {
			return {
				status: [{
						key: 1,
						name: '客户服务',
						url: '/static/imgs/img/ucenter/one.png',
						next: './myOrders?current=1',
						imgurl:'/static/imgs/kehufuwu.png',
						// imgurl:'/static/imgs/guodegang.png'
					},
					{
						key: 2,
						name: '评价管理',
						url: '/static/imgs/img/ucenter/2.png',
						next: './myOrders?current=2',
						imgurl:'/static/imgs/pingjiaguanli.png'
					},
					{
						key: 3,
						name: '意见反馈',
						url: '/static/imgs/img/ucenter/3.png',
						next: './myOrders?current=0',
						imgurl:'/static/imgs/yijianfankui.png'
					},
					{
						key: 4,
						name: '查禁区',
						url: '/static/imgs/img/ucenter/4.png',
						next: './myOrders?current=0',
						imgurl:'/static/imgs/daohangjinchaqu.png'
					}
				],
				status2: [{
						key: 1,
						imgurl:'/static/imgs/QQ20210123222444.png'
						// imgurl:'/static/imgs/guodegang.png'
					},
					{
						key: 2,
						imgurl:'/static/imgs/QQ20210123222459.png'
					},
					{
						key: 3,
						imgurl:'/static/imgs/QQ20210123222507.png'
					}
				],
				status3: [{
						key: 1,
						name: '法律公告',
						imgurl:'/static/imgs/falvgonggao.png'
						// imgurl:'/static/imgs/guodegang.png'
					}
				]
			}
		},
		methods: {
			
		}
	}
</script>

<style>
	.back {
		background-color: #F6F6F6;
	}
	
	.topbotton {
		height: 100upx;
		display: flex;
		flex-direction: row-reverse;
		margin-bottom: 30upx;
	}
	
	.littleThing {
		border: medium solid black;
		border-width: 2upx;
		border-radius: 30upx;
		margin-top: 20upx;
		width: 110upx;
		height: 50upx;
		font-size: 20upx;
		margin-left: 10upx;
		text-align: center;
	}
	
	.userInfo {
		height: 250upx;
		padding-left: 30upx;
		display: flex;
	}
	
	.userimg {
		
		width: 180upx;
		height: 180upx;
		border-radius: 50%;
	}
	
	.weirengzheng{
		/* border-color: #007AFF;
		border-width: inherit; */
		border: medium solid black;
		border-width: 1upx;
		width: 90upx;
		height: 35upx;
		font-size: 20upx;
		margin-left: 10upx;
		text-align: center;
		/* justify-content: center; */
	}
	
	.userInformation {
		padding-top: 20upx;
		padding-left: 10upx;
		display: flex;
	}
	.usuallymode {
		background-color: #FFFFFD;
		margin: auto 10upx;
		border-radius: 20upx;
	}
	
	.order_status {
		display: flex;
		justify-content: space-between;
	}
	
	.ads {
			display: flex;
			justify-content: space-between;
	}
	
	.adss {
		width: 140upx;
		font-size: 24upx;
		text-align: center;
		letter-spacing: .5px;
		display: flex;
		flex-direction: column;
		margin-top: 30upx;
		margin-bottom: 30upx;
	}
	
	.status {
		width: 140upx;
		font-size: 24upx;
		text-align: center;
		letter-spacing: .5px;
		display: flex;
		flex-direction: column;
		margin-top: 30upx;
		margin-bottom: 30upx;
	}
	
	.icon {
		width: 50upx;
		height: 50upx;
		margin: 0 auto;
		margin-bottom: 5px;
	}
	
	.adsssssss {
		display: flex;
		margin-top: 30upx;
		margin-bottom: 30upx;
	}
	
	.adsImg {
		width: 285upx;
		height: 170upx;
		margin: 10upx 10upx;
		border-radius: 20upx;
	}
	

</style>
