package com.buscar.farmaciapopular.data.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pharmacy(
    @SerialName("UF") val uf: String,
    @SerialName("cod_municipio") val cep: String,
    @SerialName("municipio") val municipio: String,
    @SerialName("CNPJ") val cnpj: String,
    @SerialName("farmacia") val farmacia: String,
    @SerialName("endereco") val endereco: String,
    @SerialName("bairro") val bairro: String,
    @SerialName("data_credenciamento") val dataCredenciamento: String
)