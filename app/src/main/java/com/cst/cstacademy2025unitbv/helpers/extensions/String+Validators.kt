package com.cst.cstacademy2025unitbv.helpers.extensions

import android.text.TextUtils
import android.util.Patterns

fun String.isPasswordValid() = this.length > 3

fun String.isEmailValid() = !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()