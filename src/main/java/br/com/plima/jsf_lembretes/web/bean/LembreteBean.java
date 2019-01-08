package br.com.plima.jsf_lembretes.web.bean;

import br.com.plima.jsf_lembretes.web.mapper.LembreteMapper;
import br.com.plima.jsf_lembretes.web.model.Lembrete;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

//preciso dizer pro JSF que esse cara é o bean
@ManagedBean
@SessionScoped
public class LembreteBean {

    private Lembrete lembrete;
    private LembreteMapper mapper = new LembreteMapper();

    public Lembrete getLembrete() {
        return lembrete;
    }

    public List<Lembrete> getLembretes(){
        return mapper.getLembretes();
    }
}
