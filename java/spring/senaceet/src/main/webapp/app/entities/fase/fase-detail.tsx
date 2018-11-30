import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './fase.reducer';
import { IFase } from 'app/shared/model/fase.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IFaseDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class FaseDetail extends React.Component<IFaseDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { faseEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="senaceetApp.fase.detail.title">Fase</Translate> [<b>{faseEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="nombre">
                <Translate contentKey="senaceetApp.fase.nombre">Nombre</Translate>
              </span>
            </dt>
            <dd>{faseEntity.nombre}</dd>
            <dt>
              <span id="estado">
                <Translate contentKey="senaceetApp.fase.estado">Estado</Translate>
              </span>
            </dt>
            <dd>{faseEntity.estado}</dd>
            <dt>
              <span id="hora">
                <Translate contentKey="senaceetApp.fase.hora">Hora</Translate>
              </span>
            </dt>
            <dd>
              <TextFormat value={faseEntity.hora} type="date" format={APP_DATE_FORMAT} />
            </dd>
            <dt>
              <Translate contentKey="senaceetApp.fase.proyecto">Proyecto</Translate>
            </dt>
            <dd>{faseEntity.proyecto ? faseEntity.proyecto.codigo : ''}</dd>
          </dl>
          <Button tag={Link} to="/entity/fase" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/fase/${faseEntity.id}/edit`} replace color="primary">
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

const mapStateToProps = ({ fase }: IRootState) => ({
  faseEntity: fase.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(FaseDetail);
