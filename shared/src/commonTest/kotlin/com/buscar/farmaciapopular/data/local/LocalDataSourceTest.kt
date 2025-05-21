package com.buscar.farmaciapopular.data.local

import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class LocalDataSourceTest {
    private lateinit var localDataSource: LocalDataSource

    @BeforeTest
    fun setup() {
        localDataSource = LocalDataSourceImpl()
    }

    @Test
    fun `should get all pharmacies`() =
        runTest {
            val result = localDataSource.getAllPharmacies()
            assertTrue(result.isNotEmpty())
        }
}