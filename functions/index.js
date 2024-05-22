const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp();

// Utility function to log errors
const handleError = (error, res) => {
    console.error('Error updating Firebase:', error);
    res.status(500).send('Internal Server Error');
};

// Function to handle product creation and updates
exports.handleProductChange = functions.https.onRequest(async (req, res) => {
    if (req.method !== 'POST') {
        return res.status(405).send('Method Not Allowed');
    }

    const productData = req.body;

    try {
        await admin.database().ref(`products/${productData.id}`).set(productData);
        return res.status(200).send('Product created/updated in Firebase');
    } catch (error) {
        return handleError(error, res);
    }
});

// Function to handle product deletions
exports.handleProductDelete = functions.https.onRequest(async (req, res) => {
    if (req.method !== 'POST') {
        return res.status(405).send('Method Not Allowed');
    }

    const productId = req.body.id;

    try {
        await admin.database().ref(`products/${productId}`).remove();
        return res.status(200).send('Product deleted from Firebase');
    } catch (error) {
        return handleError(error, res);
    }
});

// Function to handle product restoration
exports.handleProductRestore = functions.https.onRequest(async (req, res) => {
    if (req.method !== 'POST') {
        return res.status(405).send('Method Not Allowed');
    }

    const productData = req.body;

    try {
        await admin.database().ref(`products/${productData.id}`).set(productData);
        return res.status(200).send('Product restored in Firebase');
    } catch (error) {
        return handleError(error, res);
    }
});

// Function to handle order creation
exports.handleOrderCreate = functions.https.onRequest(async (req, res) => {
    if (req.method !== 'POST') {
        return res.status(405).send('Method Not Allowed');
    }

    const orderData = req.body;

    try {
        await admin.database().ref(`orders/${orderData.id}`).set(orderData);
        return res.status(200).send('Order created in Firebase');
    } catch (error) {
        return handleError(error, res);
    }
});
