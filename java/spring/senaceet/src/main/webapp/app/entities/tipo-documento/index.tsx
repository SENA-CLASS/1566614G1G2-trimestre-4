import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import TipoDocumento from './tipo-documento';
import TipoDocumentoDetail from './tipo-documento-detail';
import TipoDocumentoUpdate from './tipo-documento-update';
import TipoDocumentoDeleteDialog from './tipo-documento-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={TipoDocumentoUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={TipoDocumentoUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={TipoDocumentoDetail} />
      <ErrorBoundaryRoute path={match.url} component={TipoDocumento} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={TipoDocumentoDeleteDialog} />
  </>
);

export default Routes;
