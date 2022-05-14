package com.x18392911.final.advocate.recommendations.model

data class RequestConfiguration(
  val apiVersion: Int,
  val apiVersionMinor: Int,
  val allowedPaymentMethods: List<MutableMap<String, Any>>
)