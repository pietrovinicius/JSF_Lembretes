package br.com.plima.jsf_lembretes.web.mapper;


import br.com.plima.jsf_lembretes.web.model.Lembrete;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//essa classe va controlar o arraylist de lembretes
public class LembreteMapper {
    private List<Lembrete> lembretes = new ArrayList<Lembrete>();

    public LembreteMapper() {
        Instant agora = LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();

        Lembrete lembrete = new Lembrete();
        lembrete.setId(1L);
        lembrete.setTitulo("Comprar leite");
        lembrete.setDescricao("Hoje, 11h");
        lembrete.setDataCadastro(Date.from(agora));
        lembrete.setDataInicio(Date.from(agora));

        adicionar(lembrete);
    }

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public void adicionar(Lembrete lembrete) {
        lembrete.setId(lembretes.size() + 1);

        Instant agora = LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date hoje = Date.from(agora);
        lembrete.setDataCadastro(hoje);

        lembretes.add(lembrete);
    }

    public void remover(Lembrete lembrete) {
        try {
            lembrete = buscar(lembrete.getId());

            lembretes.remove(lembrete);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void editar(Lembrete lembrete) {
        try {
            for (Lembrete it : lembretes) {
                if (it.getId() == lembrete.getId()) {
                    it = lembrete;
                    //no momento que encontrar algo ele sai do looping
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Lembrete buscar(long id) {
        Lembrete lembrete = null;

        try {
            for (Lembrete it : lembretes) {
                if (it.getId() == id) {
                    lembrete = it;
                    //no momento que encontrar algo ele sai do looping
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
        }

        return lembrete;
    }
}
