import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { UserAuthService } from '../services/user-auth.service';

export const authGuard: CanActivateFn = (route, state) => {
  const isAuth = inject(UserAuthService);
  return isAuth.isLogin() ? true : inject(Router).createUrlTree(['/login']);
};
