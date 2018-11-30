import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Proyecto from './proyecto';
import ProyectoDetail from './proyecto-detail';
import ProyectoUpdate from './proyecto-update';
import ProyectoDeleteDialog from './proyecto-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={ProyectoUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={ProyectoUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={ProyectoDetail} />
      <ErrorBoundaryRoute path={match.url} component={Proyecto} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={ProyectoDeleteDialog} />
  </>
);

export default Routes;
