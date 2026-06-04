package com.ryftpay.android.ui.dropin

import com.ryftpay.android.ui.TestData.GB_COUNTRY_CODE
import com.ryftpay.android.ui.TestData.MERCHANT_NAME
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

internal class RyftDropInGooglePayConfigurationTest {

    @Test
    internal fun `existingPaymentMethodRequired should be false`() {
        RyftDropInGooglePayConfiguration(
            merchantName = MERCHANT_NAME,
            merchantCountryCode = GB_COUNTRY_CODE
        ).existingPaymentMethodRequired shouldBeEqualTo false
    }

    @Test
    internal fun `billingAddressRequired should be true`() {
        RyftDropInGooglePayConfiguration(
            merchantName = MERCHANT_NAME,
            merchantCountryCode = GB_COUNTRY_CODE
        ).billingAddressRequired shouldBeEqualTo true
    }

    @Test
    internal fun `store should default to false when not provided`() {
        RyftDropInGooglePayConfiguration(
            merchantName = MERCHANT_NAME,
            merchantCountryCode = GB_COUNTRY_CODE
        ).store shouldBeEqualTo false
    }

    @Test
    internal fun `store should be the provided value when set`() {
        RyftDropInGooglePayConfiguration(
            merchantName = MERCHANT_NAME,
            merchantCountryCode = GB_COUNTRY_CODE,
            store = true
        ).store shouldBeEqualTo true
    }
}
