import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { IProyecto } from 'app/shared/model/proyecto.model';
import { getEntities as getProyectos } from 'app/entities/proyecto/proyecto.reducer';
import { getEntity, updateEntity, createEntity, reset } from './fase.reducer';
import { IFase } from 'app/shared/model/fase.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IFaseUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface IFaseUpdateState {
  isNew: boolean;
  proyectoId: string;
}

export class FaseUpdate extends React.Component<IFaseUpdateProps, IFaseUpdateState> {
  constructor(props) {
    super(props);
    this.state = {
      proyectoId: '0',
      isNew: !this.props.match.params || !this.props.match.params.id
    };
  }

  componentWillUpdate(nextProps, nextState) {
    if (nextProps.updateSuccess !== this.props.updateSuccess && nextProps.updateSuccess) {
      this.handleClose();
    }
  }

  componentDidMount() {
    if (this.state.isNew) {
      this.props.reset();
    } else {
      this.props.getEntity(this.props.match.params.id);
    }

    this.props.getProyectos();
  }

  saveEntity = (event, errors, values) => {
    values.hora = new Date(values.hora);

    if (errors.length === 0) {
      const { faseEntity } = this.props;
      const entity = {
        ...faseEntity,
        ...values
      };

      if (this.state.isNew) {
        this.props.createEntity(entity);
      } else {
        this.props.updateEntity(entity);
      }
    }
  };

  handleClose = () => {
    this.props.history.push('/entity/fase');
  };

  render() {
    const { faseEntity, proyectos, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="senaceetApp.fase.home.createOrEditLabel">
              <Translate contentKey="senaceetApp.fase.home.createOrEditLabel">Create or edit a Fase</Translate>
            </h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : faseEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="id">
                      <Translate contentKey="global.field.id">ID</Translate>
                    </Label>
                    <AvInput id="fase-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="nombreLabel" for="nombre">
                    <Translate contentKey="senaceetApp.fase.nombre">Nombre</Translate>
                  </Label>
                  <AvField
                    id="fase-nombre"
                    type="text"
                    name="nombre"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      maxLength: { value: 40, errorMessage: translate('entity.validation.maxlength', { max: 40 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="estadoLabel">
                    <Translate contentKey="senaceetApp.fase.estado">Estado</Translate>
                  </Label>
                  <AvInput
                    id="fase-estado"
                    type="select"
                    className="form-control"
                    name="estado"
                    value={(!isNew && faseEntity.estado) || 'ACTIVO'}
                  >
                    <option value="ACTIVO">
                      <Translate contentKey="senaceetApp.Estado.ACTIVO" />
                    </option>
                    <option value="INACTIVO">
                      <Translate contentKey="senaceetApp.Estado.INACTIVO" />
                    </option>
                  </AvInput>
                </AvGroup>
                <AvGroup>
                  <Label id="horaLabel" for="hora">
                    <Translate contentKey="senaceetApp.fase.hora">Hora</Translate>
                  </Label>
                  <AvInput
                    id="fase-hora"
                    type="datetime-local"
                    className="form-control"
                    name="hora"
                    value={isNew ? null : convertDateTimeFromServer(this.props.faseEntity.hora)}
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label for="proyecto.codigo">
                    <Translate contentKey="senaceetApp.fase.proyecto">Proyecto</Translate>
                  </Label>
                  <AvInput
                    id="fase-proyecto"
                    type="select"
                    className="form-control"
                    name="proyecto.id"
                    value={isNew ? proyectos[0] && proyectos[0].id : faseEntity.proyecto.id}
                  >
                    {proyectos
                      ? proyectos.map(otherEntity => (
                          <option value={otherEntity.id} key={otherEntity.id}>
                            {otherEntity.codigo}
                          </option>
                        ))
                      : null}
                  </AvInput>
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/fase" replace color="info">
                  <FontAwesomeIcon icon="arrow-left" />
                  &nbsp;
                  <span className="d-none d-md-inline">
                    <Translate contentKey="entity.action.back">Back</Translate>
                  </span>
                </Button>
                &nbsp;
                <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                  <FontAwesomeIcon icon="save" />
                  &nbsp;
                  <Translate contentKey="entity.action.save">Save</Translate>
                </Button>
              </AvForm>
            )}
          </Col>
        </Row>
      </div>
    );
  }
}

const mapStateToProps = (storeState: IRootState) => ({
  proyectos: storeState.proyecto.entities,
  faseEntity: storeState.fase.entity,
  loading: storeState.fase.loading,
  updating: storeState.fase.updating,
  updateSuccess: storeState.fase.updateSuccess
});

const mapDispatchToProps = {
  getProyectos,
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(FaseUpdate);
