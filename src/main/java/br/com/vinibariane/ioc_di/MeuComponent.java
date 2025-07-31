package br.com.vinibariane.ioc_di;

import org.springframework.stereotype.Service;

@Service
public class MeuComponent {

    public String chamarMeuComponent() {
        return "MeuComponent foi chamado!";
    }

}
