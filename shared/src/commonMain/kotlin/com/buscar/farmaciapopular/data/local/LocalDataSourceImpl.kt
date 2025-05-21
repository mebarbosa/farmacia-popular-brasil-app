package com.buscar.farmaciapopular.data.local

import com.buscar.farmaciapopular.data.model.Pharmacy

class LocalDataSourceImpl : LocalDataSource {
    private val pharmacyList =
        listOf(
            Pharmacy(
                uf = "AC",
                cep = "1200013",
                municipio = "ACRELANDIA",
                cnpj = "26.124.718/0001-83",
                farmacia = "FARMACIA DO TRABALHADOR DE ACRELANDIA LTDA",
                endereco = "AVENIDA GERALDO BARBOSA, N° 506",
                bairro = "CENTRO",
                dataCredenciamento = "29/09/2023"
            ),
            Pharmacy(
                uf = "AC",
                cep = "1200104",
                municipio = "BRASILEIA",
                cnpj = "04.521.258/0007-80",
                farmacia = "J CRUZ LTDA",
                endereco = "AV MANOEL MARINHO MONTE, N°1136",
                bairro = "TRES BOTEQUINS",
                dataCredenciamento = "11/08/2023"
            ),
            Pharmacy(
                uf = "AC",
                cep = "1200104",
                municipio = "BRASILEIA",
                cnpj = "06.626.253/0456-86",
                farmacia = "EMPREENDIMENTOS PAGUE MENOS S/A",
                endereco = "DOUTOR MANOEL MARINHO MONTE 801",
                bairro = "BOTEQUINS",
                dataCredenciamento = "06/11/2013"
            ),
            Pharmacy(
                uf = "AC",
                cep = "1200203",
                municipio = "CRUZEIRO DO SUL",
                cnpj = "06.011.700/0001-68",
                farmacia = "H. R. LIMA",
                endereco = "CEL. MANCIO LIMA",
                bairro = "CENTRO",
                dataCredenciamento = "12/06/2015"
            ),
            Pharmacy(
                uf = "AC",
                cep = "1200203",
                municipio = "CRUZEIRO DO SUL",
                cnpj = "06.626.253/0522-08",
                farmacia = "EMPREENDIMENTOS PAGUE MENOS S/A",
                endereco = "Avenida CORONEL MANCIO LIMA, 421",
                bairro = "BAIXA",
                dataCredenciamento = "06/11/2013"
            ),
            Pharmacy(
                uf = "AC",
                cep = "1200252",
                municipio = "EPITACIOLANDIA",
                cnpj = "04.508.370/0001-95",
                farmacia = "BEATRIZ BARROSO SAADY",
                endereco = "AVENIDA SANTOS DUMONT, 295",
                bairro = "CENTRO",
                dataCredenciamento = "03/03/2015"
            ),
            Pharmacy(
                uf = "AC",
                cep = "1200252",
                municipio = "EPITACIOLANDIA",
                cnpj = "04.521.258/0028-04",
                farmacia = "J CRUZ LTDA",
                endereco = "AV SANTOS DUMONT, N°315",
                bairro = "CENTRO",
                dataCredenciamento = "11/08/2023"
            ),
            Pharmacy(
                uf = "AC",
                cep = "1200252",
                municipio = "EPITACIOLANDIA",
                cnpj = "14.351.621/0001-24",
                farmacia = "MARIA DA SILVA FREITAS",
                endereco = "SANTOS DUMONT",
                bairro = "CENTRO",
                dataCredenciamento = "11/08/2023"
            ),
            Pharmacy(
                uf = "AC",
                cep = "1200302",
                municipio = "FEIJO",
                cnpj = "03.608.877/0001-58",
                farmacia = "R V N FELICIO",
                endereco = "AVENIDA MARECHAL DEODORO 780",
                bairro = "CENTRO",
                dataCredenciamento = "05/05/2014"
            ),
            Pharmacy(
                uf = "AC",
                cep = "1200385",
                municipio = "PLACIDO DE CASTRO",
                cnpj = "04.509.006/0001-40",
                farmacia = "SERGIO CARLOS VIEIRA",
                endereco = "EPITACIO PESSOA 500",
                bairro = "CENTRO",
                dataCredenciamento = "05/05/2014"
            )
        )

    override suspend fun getAllPharmacies(): List<Pharmacy> {
        return pharmacyList
    }
}