import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './proyecto.reducer';
import { IProyecto } from 'app/shared/model/proyecto.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IProyectoDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class ProyectoDetail extends React.Component<IProyectoDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { proyectoEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="senaceetApp.proyecto.detail.title">Proyecto</Translate> [<b>{proyectoEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="codigo">
                <Translate contentKey="senaceetApp.proyecto.codigo">Codigo</Translate>
              </span>
            </dt>
            <dd>{proyectoEntity.codigo}</dd>
            <dt>
              <span id="nombre">
                <Translate contentKey="senaceetApp.proyecto.nombre">Nombre</Translate>
              </span>
            </dt>
            <dd>{proyectoEntity.nombre}</dd>
            <dt>
              <span id="estado">
                <Translate contentKey="senaceetApp.proyecto.estado">Estado</Translate>
              </span>
            </dt>
            <dd>{proyectoEntity.estado}</dd>
          </dl>
          <Button tag={Link} to="/entity/proyecto" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/proyecto/${proyectoEntity.id}/edit`} replace color="primary">
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

const mapStateToProps = ({ proyecto }: IRootState) => ({
  proyectoEntity: proyecto.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ProyectoDetail);
