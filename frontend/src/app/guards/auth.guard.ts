import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { UserAuthService } from '../services/user-auth.service';

export const authGuard: CanActivateFn = (route, state) => {
  const isAuth = inject(UserAuthService);
  const isLogin = isAuth.isLogin().getValue();
  // console.log(isLogin);
  return isLogin ? true : inject(Router).createUrlTree(['/login']);
};
