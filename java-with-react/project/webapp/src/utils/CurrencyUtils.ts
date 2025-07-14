class CurrencyUtils {
  static formatCurrency(amount: number, currency: string = 'USD'): string {
    return new Intl.NumberFormat('en-US', {
      style: 'currency',
      currency: currency,
    }).format(amount);
  }

  static parseCurrency(value: string): number {
    return parseFloat(value.replace(/[^0-9.-]+/g, ""));
  }
}

export default CurrencyUtils;