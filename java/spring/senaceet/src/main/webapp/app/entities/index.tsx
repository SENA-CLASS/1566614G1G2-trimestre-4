import React from 'react';
import { Switch } from 'react-router-dom';

// tslint:disable-next-line:no-unused-variable
import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import TipoDocumento from './tipo-documento';
import Cliente from './cliente';
import Proyecto from './proyecto';
import Fase from './fase';
/* jhipster-needle-add-route-import - JHipster will add routes here */

const Routes = ({ match }) => (
  <div>
    <Switch>
      {/* prettier-ignore */}
      <ErrorBoundaryRoute path={`${match.url}/tipo-documento`} component={TipoDocumento} />
      <ErrorBoundaryRoute path={`${match.url}/cliente`} component={Cliente} />
      <ErrorBoundaryRoute path={`${match.url}/proyecto`} component={Proyecto} />
      <ErrorBoundaryRoute path={`${match.url}/fase`} component={Fase} />
      {/* jhipster-needle-add-route-path - JHipster will routes here */}
    </Switch>
  </div>
);

export default Routes;
