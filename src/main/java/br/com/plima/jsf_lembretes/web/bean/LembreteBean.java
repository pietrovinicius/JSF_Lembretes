package br.com.plima.jsf_lembretes.web.bean;

import br.com.plima.jsf_lembretes.web.mapper.LembreteMapper;
import br.com.plima.jsf_lembretes.web.model.Lembrete;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

//preciso dizer pro JSF que esse cara é o bean
@ManagedBean
@SessionScoped
public class LembreteBean {

    private Lembrete lembrete;
    private LembreteMapper mapper = new LembreteMapper();

    @PostConstruct
    public void init(){
        lembrete = new Lembrete();
    }

    //pegando o lembrete
    public Lembrete getLembrete() {
        return lembrete;
    }

    //a lista que estamos trabalhando
    public List<Lembrete> getLembretes() {
        return mapper.getLembretes();
    }

    public String adicionar() {
        mapper.adicionar(lembrete);

        lembrete = new Lembrete();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,
                new FacesMessage("Lembrete adicionado com sucesso!"));
        context.getExternalContext().getFlash().setKeepMessages(true);

        return "index.xhtml";
    }

}
