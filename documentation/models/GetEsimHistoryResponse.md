# GetEsimHistoryResponse

**Properties**

| Name | Type                                                      | Required | Description |
| :--- | :-------------------------------------------------------- | :------- | :---------- |
| esim | [GetEsimHistoryResponseEsim](#getesimhistoryresponseesim) | ✅        |             |

# GetEsimHistoryResponseEsim

**Properties**

| Name    | Type                                                                                  | Required | Description    |
| :------ | :------------------------------------------------------------------------------------ | :------- | :------------- |
| iccid   | String                                                                                | ✅        | ID of the eSIM |
| history | [List<GetEsimHistoryResponseEsimHistoryItem>](#getesimhistoryresponseesimhistoryitem) | ✅        |                |

# GetEsimHistoryResponseEsimHistoryItem

**Properties**

| Name       | Type           | Required | Description                                                                                                                         |
| :--------- | :------------- | :------- | :---------------------------------------------------------------------------------------------------------------------------------- |
| status     | String         | ✅        | The status of the eSIM at a given time, possible values are 'RELEASED', 'DOWNLOADED', 'INSTALLED', 'ENABLED', 'DELETED', or 'ERROR' |
| statusDate | OffsetDateTime | ✅        | The date when the eSIM status changed in the format 'yyyy-MM-ddThh:mm:ssZZ'                                                         |
| date       | Double         | ❌        | Epoch value representing the date when the eSIM status changed                                                                      |
