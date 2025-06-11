package com.cst.cstacademy2025unitbv.models.dummyData

import com.cst.cstacademy2025unitbv.models.one_to_many.UserAddressModel

fun getRandomUserAddress() = getUserAddresses().random()

fun getUserAddresses() = listOf(
    UserAddressModel(
        id = "1",
        street = "Street 1",
        streetNumber = 1
    ),
    UserAddressModel(
        id = "2",
        street = "Street 2",
        streetNumber = 2
    ),
    UserAddressModel(
        id = "3",
        street = "Street 3",
        streetNumber = 3
    ),
    UserAddressModel(
        id = "4",
        street = "Street 4",
        streetNumber = 4
    ),
    UserAddressModel(
        id = "5",
        street = "Street 5",
        streetNumber = 5
    ),
    UserAddressModel(
        id = "6",
        street = "Street 6",
        streetNumber = 6
    ),
    UserAddressModel(
        id = "7",
        street = "Street 7",
        streetNumber = 7
    ),
    UserAddressModel(
        id = "8",
        street = "Street 8",
        streetNumber = 8
    ),
    UserAddressModel(
        id = "9",
        street = "Street 9",
        streetNumber = 9
    ),
    UserAddressModel(
        id = "10",
        street = "Street 10",
        streetNumber = 10
    )
)