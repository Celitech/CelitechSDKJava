# GetEsimOkResponseEsim

**Properties**

| Name                 | Type    | Required | Description                                                                                                                    |
| :------------------- | :------ | :------- | :----------------------------------------------------------------------------------------------------------------------------- |
| iccid                | String  | ✅       | ID of the eSIM                                                                                                                 |
| smdpAddress          | String  | ✅       | SM-DP+ Address                                                                                                                 |
| manualActivationCode | String  | ✅       | The manual activation code                                                                                                     |
| status               | String  | ✅       | Status of the eSIM, possible values are 'RELEASED', 'DOWNLOADED', 'INSTALLED', 'ENABLED', 'DELETED', or 'ERROR'                |
| isTopUpAllowed       | Boolean | ✅       | Indicates whether the eSIM is currently eligible for a top-up. This flag should be checked before attempting a top-up request. |
