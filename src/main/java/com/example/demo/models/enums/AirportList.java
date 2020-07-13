package com.example.demo.models.enums;

public enum AirportList {
    Anaa_Airport("AAA"), Loakan_Airport("BAG"), Carauari_Airport("CAF"),
    Daru_Airport("DAU"), Eagle_Airport("EAA"), Faranah_Airport("FAA"),
    Gabbs_Airport("GAB"), Hasvik_Airport("HAA"), Igark_Airport("IAA"),
    Jalalabad_Airport("JAA"), Kasama_Airport("KAA"), Lamar_Municipal_Airport("LAA"),
    Chennai_International_Airport("MAA"), Naha_Airport("NAH"), Bagram_Airfield("OAI"),
    Bilaspur_Airport("PAB"), Bella_Coola_Airport("QBC"), Riga_International_Airport("RIX"),
    Shively_Field("SAA"), Perry_Stokes_Airport("TAD"), Narsarsuaq_Airport("UAK"),
    Vilnius_Airport("VNO"), Whanganui_Airport("WAG"), Xinyang_Minggang_Airport("XAI"),
    Anahim_Lake_Airport("YAA"), Zadar_Airport("ZAD");

    private String airportName;

    private AirportList(String airportName) {
        this.airportName = airportName;
    }
    public String getAirportName() {
        return airportName;
    }
}

