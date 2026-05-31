package com.ryftpay.android.core.model.payment

data class PaymentMethod(
    val type: PaymentMethodType,
    val cardDetails: CardDetails?,
    val id: String?,
    val googlePayToken: String?,
    val billingAddress: Address?,
    val options: PaymentMethodOptions?
) {
    companion object {
        fun card(cardDetails: CardDetails, options: PaymentMethodOptions) = PaymentMethod(
            type = PaymentMethodType.Card,
            cardDetails,
            id = null,
            googlePayToken = null,
            billingAddress = null,
            options
        )

        fun id(id: String) = PaymentMethod(
            type = PaymentMethodType.Id,
            cardDetails = null,
            id,
            googlePayToken = null,
            billingAddress = null,
            options = null
        )

        // FORK: accept payment-method options (e.g. store=true) so a Google Pay payment can
        // vault the card. Defaults to null to preserve the original pay-now-only behaviour.
        fun googlePay(
            googlePayToken: String,
            billingAddress: Address?,
            options: PaymentMethodOptions? = null
        ) = PaymentMethod(
            type = PaymentMethodType.GooglePay,
            cardDetails = null,
            id = null,
            googlePayToken,
            billingAddress,
            options
        )
    }
}
