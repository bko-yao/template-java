package com.start.templatejava.services;

public class ServiceAccountServiceTest {

    /*private final ServiceAccountRepository serviceAccountRepositoryMock = mock(ServiceAccountRepository.class);
    private final ModelMapper modelMapperMock = mock(ModelMapper.class);
    private final PasswordTokenRepository passwordTokenRepositoryMock = mock(PasswordTokenRepository.class);
    private final ServiceAccountEmployeeProviderRepository serviceAccountEmployeeProviderRepository = mock(ServiceAccountEmployeeProviderRepository.class);
    private final MailService mailServiceMock = mock(MailService.class);
    private final MailMessageFactory mailMessageFactoryMock = mock(MailMessageFactory.class);
    private final EntrepriseRepository entrepriseRepositoryMock = mock(EntrepriseRepository.class);
    private final RoleHelper roleHelperMock = mock(RoleHelper.class);
    private final PasswordEncoder encoderMock = mock(PasswordEncoder.class);
    private final PersonRepository personRepository = mock(PersonRepository.class);
    private final ZoneRepository zoneRepository = mock(ZoneRepository.class);
    private ServiceAccountService serviceAccountService;
    private ServiceAccount serviceAccountMock;*/

   /* @BeforeEach
    void setUp() {
        // Créer une instance de la classe à tester
        this.serviceAccountService = new ServiceAccountService(modelMapperMock, encoderMock,
                serviceAccountRepositoryMock, serviceAccountEmployeeProviderRepository,
                entrepriseRepositoryMock, personRepository, roleHelperMock, zoneRepository);
        serviceAccountMock = mock(ServiceAccount.class);
    }*/

    // TODO TEST A DEPLACER DANS PASSWORDRESETtEST
    /*@Test
    public void testChangeUserPassword() {
        // GIVEN
        String newPassword = "nouveauMotDePasse";
        String encodedPassword = "motDePasseEncode";
        when(encoderMock.encode(newPassword.trim())).thenReturn(encodedPassword);

        // WHEN
        this.serviceAccountService.changeUserPassword(serviceAccountMock, newPassword);

        // THEN
        verify(serviceAccountMock).setPassword(encodedPassword);
        verify(serviceAccountRepositoryMock).save(serviceAccountMock);
    }*/

    /*
    @Test
    void testAddNewServiceAccount() {
        // GIVEN
        int idEntreprise = 1;
        String roleAdmin = "ROLE_ADMIN";
        String roleUser = "ROLE_USER";
        ServiceAccountDTO serviceAccountDTOMock = new ServiceAccountDtoMockBuilder()
                .setRoles(Set.of(roleAdmin, roleUser))
                .setEmail("admin@admin.com")
                .setPhoneNumber("0102030405")
                .setPassword("123456")
                .build();

        Entreprise entreprise = mock(Entreprise.class);
        Role role = mock(Role.class);

        when(entrepriseRepositoryMock.findByIdAndPersonType(idEntreprise)).thenReturn(of(entreprise));
        when(roleHelperMock.addRole(roleAdmin)).thenReturn(role);
        when(roleHelperMock.addRole(roleUser)).thenReturn(role);
        when(modelMapperMock.map(serviceAccountDTOMock, ServiceAccount.class)).thenReturn(serviceAccountMock);
        when(serviceAccountRepositoryMock.existsByEmail(serviceAccountDTOMock.getEmail())).thenReturn(false);
        when(serviceAccountRepositoryMock.existsByPhoneNumber(serviceAccountDTOMock.getPhoneNumber())).thenReturn(false);

        // WHEN
        ResponseEntity<?> response = serviceAccountService.addNewServiceAccount(idEntreprise, serviceAccountDTOMock);

        // THEN
        verify(entrepriseRepositoryMock, times(1)).findByIdAndPersonType(idEntreprise);
        verify(roleHelperMock, times(2)).addRole(anyString());
        verify(serviceAccountRepositoryMock).save(serviceAccountMock);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }*/

    /*@Test
    void testVerifyIfEmailOrPhoneNumberExist_EmailAlreadyExists() {
        // GIVEN
        String email = "existing_email@example.com";
        ServiceAccountDTO serviceAccountDTOMock = new ServiceAccountDtoMockBuilder()
                .setEmail(email.toLowerCase().trim())
                .build();

        // WHEN
        when(serviceAccountRepositoryMock.existsByEmail(serviceAccountDTOMock.getEmail())).thenReturn(true);
        ServiceAccountException exception = assertThrows(ServiceAccountException.class, () -> {
            serviceAccountService.verifyIfEmailOrPhoneNumberExist(serviceAccountDTOMock);
        });

        // THEN
        assertEquals("Email " + email + " is already in use!", exception.getMessage());
        assertEquals(1001, exception.getErrorCode());
    }*/

    /* @Test
    void testVerifyIfEmailOrPhoneNumberExist_PhoneNumberAlreadyExists() {
        // GIVEN
        String phoneNumber = "existing_email@example.com";
        String email = "existing_email@example.com";
        ServiceAccountDTO serviceAccountDTOMock = new ServiceAccountDtoMockBuilder()
                .setEmail(email.toLowerCase().trim())
                .setPhoneNumber(phoneNumber.toLowerCase().trim())
                .build();

        when(serviceAccountRepositoryMock.existsByPhoneNumber(serviceAccountDTOMock.getPhoneNumber())).thenReturn(true);

        // WHEN
        ServiceAccountException exception = assertThrows(ServiceAccountException.class, () -> {
            serviceAccountService.verifyIfEmailOrPhoneNumberExist(serviceAccountDTOMock);
        });

        // THEN
        assertEquals("Phone number " + phoneNumber + " is already in use!", exception.getMessage());
        assertEquals(1002, exception.getErrorCode());
    }*/

    /*@Test
    void testVerifyIfEmailOrPhoneNumberExist_NoExistingEmailOrPhoneNumber() {
        // GIVEN
        ServiceAccountDTO serviceAccountDTOMock = new ServiceAccountDtoMockBuilder()
                .setEmail("new_email@example.com".toLowerCase().trim())
                .setPhoneNumber("new_phone_number".toLowerCase().trim())
                .build();

        when(serviceAccountRepositoryMock.existsByEmail(serviceAccountDTOMock.getEmail())).thenReturn(false);
        when(serviceAccountRepositoryMock.existsByPhoneNumber(serviceAccountDTOMock.getPhoneNumber())).thenReturn(false);

        // WHEN - THEN
        assertDoesNotThrow(() -> {
            serviceAccountService.verifyIfEmailOrPhoneNumberExist(serviceAccountDTOMock);
        });
    }*/

    // TODO TEST A DEPLACER DANS PASSWORDRESETtEST
    /*@Test
    void testCreatePasswordResetTokenForServiceAccount_TokenExists() {
        // Mocking input data
        ServiceAccount serviceAccountMock = new ServiceAccountMockBuilder()
                .setId(1L)
                .build();
        String tokenTemporary = "temporary_token";

        // Mocking repository behavior
        PasswordResetToken existingToken = new PasswordResetToken();
        existingToken.setId(1L);
        existingToken.setServiceAccount(serviceAccountMock);
        when(passwordTokenRepositoryMock.findByServiceAccountId(serviceAccountMock.getId())).thenReturn(Optional.of(existingToken));

        // Testing the method
        serviceAccountService.createPasswordResetTokenForServiceAccount(serviceAccountMock, tokenTemporary);

        // Verifying interactions
        verify(passwordTokenRepositoryMock, times(1)).findByServiceAccountId(serviceAccountMock.getId());
        verify(passwordTokenRepositoryMock, times(1)).deleteById(existingToken.getId());
        verify(passwordTokenRepositoryMock, times(1)).flush();
        verify(passwordTokenRepositoryMock, times(1)).save(any(PasswordResetToken.class));
    }*/
    // TODO TEST A DEPLACER DANS PASSWORDRESETtEST
    /** @Test void testCreatePasswordResetTokenForServiceAccount_NoTokenExists() {
    // Mocking input data
    ServiceAccount serviceAccountMock = new ServiceAccountMockBuilder()
    .setId(1L)
    .build();
    String tokenTemporary = "temporary_token";

    // Mocking repository behavior
    when(passwordTokenRepositoryMock.findByServiceAccountId(serviceAccountMock.getId())).thenReturn(Optional.empty());

    // Testing the method
    serviceAccountService.createPasswordResetTokenForServiceAccount(serviceAccountMock, tokenTemporary);

    // Verifying interactions
    verify(passwordTokenRepositoryMock, times(1)).findByServiceAccountId(serviceAccountMock.getId());
    verify(passwordTokenRepositoryMock, never()).deleteById(anyLong());
    verify(passwordTokenRepositoryMock, never()).flush();
    verify(passwordTokenRepositoryMock, times(1)).save(any(PasswordResetToken.class));
    } */

    /** @Test public void testValidatePasswordResetToken_ValidButExpired() {
    // Créer un token valide mais expiré
    String token = "validToken";
    PasswordResetToken expiredToken = new PasswordResetToken();
    when(passwordTokenRepository.findByToken(token)).thenReturn(Optional.of(expiredToken));
    when(passwordTokenRepository.isTokenExpired(expiredToken)).thenReturn(true);

    // Créer une instance de la classe à tester
    PasswordResetTokenService tokenService = new PasswordResetTokenService(passwordTokenRepository);

    // Vérifier que la méthode renvoie "expired" pour un token valide mais expiré
    assertEquals("expired", tokenService.validatePasswordResetToken(token));
    }

     @Test public void testValidatePasswordResetToken_Invalid() {
     // Créer un token invalide
     String invalidToken = "invalidToken";
     when(passwordTokenRepository.findByToken(invalidToken)).thenReturn(Optional.empty());

     // Créer une instance de la classe à tester
     PasswordResetTokenService tokenService = new PasswordResetTokenService(passwordTokenRepository);

     // Vérifier que la méthode renvoie "invalidToken" pour un token invalide
     assertEquals("invalidToken", tokenService.validatePasswordResetToken(invalidToken));
     }*/
}

