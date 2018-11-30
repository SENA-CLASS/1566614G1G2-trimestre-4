import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './tipo-documento.reducer';
import { ITipoDocumento } from 'app/shared/model/tipo-documento.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ITipoDocumentoDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class TipoDocumentoDetail extends React.Component<ITipoDocumentoDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { tipoDocumentoEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="senaceetApp.tipoDocumento.detail.title">TipoDocumento</Translate> [<b>{tipoDocumentoEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="sigla">
                <Translate contentKey="senaceetApp.tipoDocumento.sigla">Sigla</Translate>
              </span>
            </dt>
            <dd>{tipoDocumentoEntity.sigla}</dd>
            <dt>
              <span id="nombreDocumento">
                <Translate contentKey="senaceetApp.tipoDocumento.nombreDocumento">Nombre Documento</Translate>
              </span>
            </dt>
            <dd>{tipoDocumentoEntity.nombreDocumento}</dd>
            <dt>
              <span id="estado">
                <Translate contentKey="senaceetApp.tipoDocumento.estado">Estado</Translate>
              </span>
            </dt>
            <dd>{tipoDocumentoEntity.estado}</dd>
          </dl>
          <Button tag={Link} to="/entity/tipo-documento" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/tipo-documento/${tipoDocumentoEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.edit">Edit</Translate>
            </span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ tipoDocumento }: IRootState) => ({
  tipoDocumentoEntity: tipoDocumento.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(TipoDocumentoDetail);
