package com.example.springbootsecurity2mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    /*
    Ketika di auto wire maka akan berlaku untuk semua scoop aplikasi
    Testing 
    Bahkan jika dibuka pada browser dan komputer lain: maka akan bernilai sama
    Jadi semacam Variable Global
    */
    @Autowired
    @Qualifier("fooMahasiswa")
    private Mahasiswa mahasiswa;  //Qualifier: untuk memastikan saja

    @GetMapping("/greeting_init")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="Mas Kirun") String name, Model uiModel) {
        uiModel.addAttribute("name", name);
        int umur = 20;
        uiModel.addAttribute("umur", umur);
        
        mahasiswa.setNama("Bagus Winarno");
        mahasiswa.setAlamat("Dsn Wangkal Ds. Tengger Lor Kec. Kunjang Keb Kediri");
        uiModel.addAttribute("mahasiswa", mahasiswa);

        /*
        Return ini adalah merupakan nama file yang ada di resource
        biasanay di bawah resource/template : oleh karena standart struktur dari thy
        */
		return "template_greeting"; 
    }
    

}