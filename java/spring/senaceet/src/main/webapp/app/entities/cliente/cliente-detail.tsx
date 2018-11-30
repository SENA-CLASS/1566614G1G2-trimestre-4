import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './cliente.reducer';
import { ICliente } from 'app/shared/model/cliente.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IClienteDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class ClienteDetail extends React.Component<IClienteDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { clienteEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="senaceetApp.cliente.detail.title">Cliente</Translate> [<b>{clienteEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="numeroDocumento">
                <Translate contentKey="senaceetApp.cliente.numeroDocumento">Numero Documento</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.numeroDocumento}</dd>
            <dt>
              <span id="primerNombre">
                <Translate contentKey="senaceetApp.cliente.primerNombre">Primer Nombre</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.primerNombre}</dd>
            <dt>
              <span id="segundoNombre">
                <Translate contentKey="senaceetApp.cliente.segundoNombre">Segundo Nombre</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.segundoNombre}</dd>
            <dt>
              <span id="primerApellido">
                <Translate contentKey="senaceetApp.cliente.primerApellido">Primer Apellido</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.primerApellido}</dd>
            <dt>
              <span id="segundoApellido">
                <Translate contentKey="senaceetApp.cliente.segundoApellido">Segundo Apellido</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.segundoApellido}</dd>
            <dt>
              <Translate contentKey="senaceetApp.cliente.tipoDocumento">Tipo Documento</Translate>
            </dt>
            <dd>{clienteEntity.tipoDocumento ? clienteEntity.tipoDocumento.nombreDocumento : ''}</dd>
            <dt>
              <Translate contentKey="senaceetApp.cliente.user">User</Translate>
            </dt>
            <dd>{clienteEntity.user ? clienteEntity.user.login : ''}</dd>
          </dl>
          <Button tag={Link} to="/entity/cliente" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/cliente/${clienteEntity.id}/edit`} replace color="primary">
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

const mapStateToProps = ({ cliente }: IRootState) => ({
  clienteEntity: cliente.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ClienteDetail);
