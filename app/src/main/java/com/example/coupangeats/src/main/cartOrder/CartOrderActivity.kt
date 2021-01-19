package com.example.coupangeats.src.main.cartOrder

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass.Companion.isOrder
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityCartOrderBinding
import com.example.coupangeats.src.main.MainActivity
import com.example.coupangeats.src.main.cartOrder.models.CartOrderResponse
import com.example.coupangeats.src.main.cartOrder.models.order.BootPayResult
import com.example.coupangeats.src.main.cartOrder.models.order.OrderRequest
import com.example.coupangeats.src.main.order.OrderFragment
import com.google.gson.JsonObject
import kr.co.bootpay.Bootpay
import kr.co.bootpay.BootpayAnalytics
import kr.co.bootpay.enums.Method
import kr.co.bootpay.enums.PG
import kr.co.bootpay.enums.UX
import kr.co.bootpay.model.BootExtra
import kr.co.bootpay.model.BootUser
import org.json.JSONObject

const val TAG = "LOG"

class CartOrderActivity : BaseActivity<ActivityCartOrderBinding>(ActivityCartOrderBinding::inflate),
    CartOrderView {

    val application_id = "60001de55b294800272a1a77"
    var receipt_id = ""
    lateinit var bootMessage: BootPayResult

    var menuName = ""
    var menuPrice = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CartOrderService(this).getCartOrderResponse()

        BootpayAnalytics.init(this, application_id)

        binding.btnOrder.setOnClickListener {
            goBootpayRequest()
        }


    }


    private fun goBootpayRequest() {
        val bootUser = BootUser().setPhone("010-1234-5678")
        val bootExtra = BootExtra().setQuotas(intArrayOf(0, 2, 3))

        val stuck = 1 //재고 있음

        Bootpay.init(this)
            .setApplicationId(application_id) // 해당 프로젝트(안드로이드)의 application id 값
            .setContext(this)
            .setBootUser(bootUser)
            .setBootExtra(bootExtra)
            .setUX(UX.PG_DIALOG)
            .setPG(PG.INICIS)
            .setMethod("card")
//                .setUserPhone("010-1234-5678") // 구매자 전화번호
            .setName(menuName) // 결제할 상품명
            .setOrderId("1234") // 결제 고유번호expire_month
            .setPrice(menuPrice) // 결제할 금액
//            .addItem("마우's 스", 1, "ITEM_CODE_MOUSE", 100) // 주문정보에 담길 상품정보, 통계를 위해 사용
//            .addItem("키보드", 1, "ITEM_CODE_KEYBOARD", 200, "패션", "여성상의", "블라우스") // 주문정보에 담길 상품정보, 통계를 위해 사용
            .onConfirm { message ->
                if (0 < stuck) Bootpay.confirm(message); // 재고가 있을 경우.
                else Bootpay.removePaymentWindow(); // 재고가 없어 중간에 결제창을 닫고 싶을 경우
                Log.d("confirm", message);
            }
            .onDone { message ->

                var jsonObject = JSONObject(message)
                var receipt = jsonObject.getString("receipt_id")

                Log.d(TAG,  "message -> $message")
                Log.d(TAG, "CartOrderActivity - goBootpayRequest() : receipt_id : $receipt")

                CartOrderService(this).postOrderRequest(OrderRequest("", "", 0, receipt))
                showCustomToast("주문이 완료되었습니다.")

                isOrder = false

//                val bundle = Bundle()
//                bundle.putString("receiptId", receipt)
//                OrderFragment().arguments = bundle
//                supportFragmentManager.beginTransaction().replace(R.id.frame_main, OrderFragment()).commit()
//                finish()

                val intent = Intent(this, MainActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()


            }
            .onReady { message ->
                Log.d("ready", message)
            }
            .onCancel { message ->
                Log.d("cancel", message)
            }
            .onError { message ->
                Log.d("error", message)
            }
            .onClose { message ->
                Log.d("close", "close")
            }
            .request();


    }

    override fun onGetCartOrderResponseSuccess(response: CartOrderResponse) {
        response.cartList.forEach {
            menuName = it.menuName
        }
        var temp = response.payPrice.totalPrice.split("원")[0]
        Log.d(TAG, "CartOrderActivity - onGetCartOrderResponseSuccess() : temp $temp")
        var temp2 = temp.split(",")
        var temp3 = ""
        for (i in temp2) {
            temp3 += i
        }
        menuPrice = temp3.toInt()
        Log.d(TAG, "CartOrderActivity - onGetCartOrderResponseSuccess() : 총 금액 $menuPrice")

        response.deliveryaddress.forEach {
            binding.deliveryBuildingName.text = it.deliveryBuildingName
            binding.deliveryAddress.text = it.deliveryAddress
        }

        binding.storeName.text = response.storeName
        binding.moneyOrder.text = response.payPrice.orderPrice
        binding.moneyDelivery.text = response.payPrice.deliveryFee
        if (response.payPrice.couponPrice == null) {
            binding.couponDiscount.text = "0원"
        } else {
            binding.couponDiscount.text = response.payPrice.couponPrice.toString()
        }
        binding.totalPrice.text = response.payPrice.totalPrice
        binding.btnOrder.text = response.payPrice.totalPrice + " 결제하기"


        response.cartList.forEach {
            binding.menuName.text = it.menuName
            var temp = ""
            for (i in it.option) {
                temp += i
            }
            binding.option.text = temp
            binding.price.text = it.price
        }

        binding.couponCount.text = "${response.coupon.couponCount} 장"

        if (response.coupon.couponPrice == null) {
            binding.discountCouponPrice.text = "0"
        } else {
            binding.discountCouponPrice.text = response.coupon.couponPrice as String
        }

        binding.paymentMethod.text = response.payment.paymentMethod

    }

    override fun onGetCartOrderResponseFailure(message: String) {
    }
}