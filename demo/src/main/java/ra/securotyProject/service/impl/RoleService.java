package ra.securotyProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.securotyProject.model.domain.Role;
import ra.securotyProject.model.domain.RoleName;
import ra.securotyProject.model.domain.RoleOrder;
import ra.securotyProject.model.domain.RoleOrderName;
import ra.securotyProject.repository.IRoleOrderRepository;
import ra.securotyProject.repository.IRoleRepositoty;
import ra.securotyProject.service.IRoleService;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepositoty roleRepository;
    @Autowired
    private IRoleOrderRepository roleOrderRepository;
    @Override
    public Role findByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName)
                .orElseThrow(()->new RuntimeException("Role Not Found"));
    }

    @Override
    public RoleOrder findByRoleOrderName(RoleOrderName roleOrderName) {
        return roleOrderRepository.findByRoleOrderName(roleOrderName)
                .orElseThrow(()->new RuntimeException("Role Not Found"));
    }
}
