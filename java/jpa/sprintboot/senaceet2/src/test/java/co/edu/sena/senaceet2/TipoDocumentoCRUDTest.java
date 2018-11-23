package co.edu.sena.senaceet2;

import co.edu.sena.senaceet2.domain.TipoDocumento;
import co.edu.sena.senaceet2.repository.TipoDocumentoRepository;
import co.edu.sena.senaceet2.util.DateUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
// la siguiente es la anotacion para el manejo del orden en junit 4
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TipoDocumentoCRUDTest {

    @Autowired// inyecccion de dependias
    private  TipoDocumentoRepository tipoDocumentoRepository;

    @Test
    public void test01Insert() {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setSigla("CC");
        tipoDocumento.setNombreDocumento("Cedula de ciudadania");
        tipoDocumento.setEstado("Activa");
        tipoDocumentoRepository.save(tipoDocumento);
        Assert.assertEquals(tipoDocumento, tipoDocumentoRepository.findBySigla("CC"));
    }

    @Test
    public void test02UpdateNombreDocumento() {
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findBySigla("CC");
        tipoDocumento.setNombreDocumento("Cedula Colombiana");
        tipoDocumentoRepository.save(tipoDocumento);
        Assert.assertEquals(tipoDocumentoRepository.findBySigla("CC").getNombreDocumento(),"Cedula Colombiana");
    }

    @Test
    public void test03UpdateSigla() {
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findBySigla("CC");
        tipoDocumento.setSigla("CCC");
        tipoDocumentoRepository.save(tipoDocumento);
        Assert.assertEquals(tipoDocumentoRepository.findById(tipoDocumento.getId()).get().getSigla(),"CCC");
    }

    @Test
    public void test04FindAll() {
        List<TipoDocumento> list = tipoDocumentoRepository.findAll();
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void test99Delete() {
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findBySigla("CCC");
        tipoDocumentoRepository.delete(tipoDocumento);
        Assert.assertNull(tipoDocumentoRepository.findBySigla("CCC"));


    }
}
