package evg.testt.service.impl;

import evg.testt.dao.UserDetailsDao;
import evg.testt.model.UserDetails;
import evg.testt.service.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl extends BaseService<UserDetails, UserDetailsDao> implements UserDetailsService {

}
