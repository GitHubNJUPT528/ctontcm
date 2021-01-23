<template>
	<view>
		<!-- <view>我是服务页面</view> -->
		<view class="uni-padding-wrap uni-common-mt" style="margin-top: 10upx;width: 90%;margin-left: 5%;">
			<uni-segmented-control activeColor="#FA8623" :current="current" :values="items" style-type="button" @clickItem="onClickItem" />
		</view>
	</view>
</template>

<script>
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	
	export default {
		components: {
			// uniNavBar,
			uniSegmentedControl,
			// uniPagination,
			// uniSearchBar
		},
		data() {
			return {
				items: ['通话记录', '我的订单'],
			}
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
