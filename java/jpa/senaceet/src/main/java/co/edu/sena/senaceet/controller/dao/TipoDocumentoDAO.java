package co.edu.sena.senaceet.controller.dao;

import co.edu.sena.senaceet.model.entities.TipoDocumento;

public interface TipoDocumentoDAO extends InterfaceDao<TipoDocumento> {
    public TipoDocumento findBySigla(String sigla);
}
