import {DHL_ICON, CANPAR_ICON, PUROLATOR_ICON, FEDEX_ICON} from "../../assets/carrierIcons";

export const getCarrierIcon = (carrierName) => {
    switch(carrierName) {
        case 'Canpar':
            return CANPAR_ICON;
        case 'Purolator':
            return PUROLATOR_ICON;
        case 'Federal Express':
            return FEDEX_ICON;
        case 'DHL':
            return DHL_ICON;
        default:
            return null;
    }
}