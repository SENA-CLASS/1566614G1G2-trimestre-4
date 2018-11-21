package co.edu.sena.senaceet2;

import co.edu.sena.senaceet2.domain.TipoDocumento;
import co.edu.sena.senaceet2.repository.TipoDocumentoRepository;
import co.edu.sena.senaceet2.util.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TipoDocumentoCRUDTest {

    @Autowired
    TipoDocumentoRepository tipoDocumentoRepository;

    @Test
    public void test01Insert() {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setSigla("CC");
        tipoDocumento.setNombreDocumento("Cedula de ciudadania");
        tipoDocumento.setEstado("Activa");

        tipoDocumentoRepository.save(tipoDocumento);

        Date fechavieja = DateUtils.asDate(LocalDate.of(2108,12,11));


    }

}
